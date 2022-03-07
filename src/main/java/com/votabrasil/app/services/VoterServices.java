package com.votabrasil.app.services;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.validation.Valid;

import com.votabrasil.app.dtos.CredentialsDTO;
import com.votabrasil.app.dtos.VoterLoginDTO;
import com.votabrasil.app.dtos.VoterRegisterDTO;
import com.votabrasil.app.model.VoterModel;
import com.votabrasil.app.repositories.VoterRepository;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Class service of operations from Voter
 * 
 * @author Boaz
 * @since 07/03/2022
 * @version 1.0
 */
@Service
public class VoterServices {

    private @Autowired VoterRepository repository;
    private VoterModel newVoter;

    /**
     * Method to register a new user voter
     * 
     * @param VoterRegisterDTO
     * @return ResponseEntity<VoterModel>
     */
    public ResponseEntity<VoterModel> registerVoter(VoterRegisterDTO voter) {
        Optional<VoterModel> optional = repository.findByEmail(voter.getEmail());

        if (optional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		    voter.setPassword(encoder.encode(voter.getPassword()));

            newVoter = new VoterModel(
                            voter.getName(),
                            voter.getCpf(),
                            voter.getEmail(),
                            voter.getPassword());
                            
            return ResponseEntity.status(201).body(repository.save(newVoter));
        }
    }

    /**
     * Method to login a user voter
     * 
     * @param VoterLoginDTO
     * @return ResponseEntity<VoterModel>
     */
    public ResponseEntity<CredentialsDTO> validCredentials(@Valid VoterLoginDTO voter) {
        return repository.findByEmail(voter.getEmail())
                .map(v -> {
                    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                    if (encoder.matches(voter.getPassword(), v.getPassword())) {
                        CredentialsDTO credentials = new CredentialsDTO(
                                v.getIdVoter(),
                                v.getName(),
                                v.getEmail(),
                                generatorBasicToken(voter.getEmail(), voter.getPassword()));
                        return ResponseEntity.status(200).body(credentials);
                    } else {
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
                    }
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email not found"));
    }

    /**
     * Method to generate a basic token
     * 
     * @param String email
     * @param String password
     * @return String
     */
    private static String generatorBasicToken(String email, String password) {
        String structure = email + ":" + password;
        byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(structureBase64);
    }
    
}
