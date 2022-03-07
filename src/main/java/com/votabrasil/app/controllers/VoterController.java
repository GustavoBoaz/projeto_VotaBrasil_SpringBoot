package com.votabrasil.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.votabrasil.app.dtos.CredentialsDTO;
import com.votabrasil.app.dtos.VoterLoginDTO;
import com.votabrasil.app.dtos.VoterRegisterDTO;
import com.votabrasil.app.model.VoterModel;
import com.votabrasil.app.repositories.VoterRepository;
import com.votabrasil.app.services.VoterServices;

/**
 * Class controller of operations from Voter
 * 
 * @author Gabriel
 * @author Raiza
 * @author Boaz
 * @since 23/02/2022
 * @version 0.0.1
 *
 */
@RestController
@RequestMapping("/api/v1/voters")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VoterController {
	
	private @Autowired VoterRepository repository;
	private @Autowired VoterServices services;
	
	@GetMapping
	public List<VoterModel> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VoterModel> getById(@PathVariable(value = "id") Long idVoter) {
		return repository.findById(idVoter)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Não existe aqui Féra!");
				});
	}

	@PutMapping("/auth")
	public ResponseEntity<CredentialsDTO> getCredentials(@Valid @RequestBody VoterLoginDTO voter){
		return services.validCredentials(voter);
	}
	
	@PostMapping
	public ResponseEntity<VoterModel> save(@Valid @RequestBody VoterRegisterDTO voter) {
		return services.registerVoter(voter);
	}
	
	@PutMapping
	public ResponseEntity<VoterModel> update(@RequestBody VoterModel voter) {
		return repository.findById(voter.getIdVoter())
				.map(resp -> ResponseEntity.status(200).body(repository.save(voter)))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não encontrado");
				});
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable(value = "id") Long idVoter) {
		return repository.findById(idVoter)
				.map(resp -> {
					repository.deleteById(idVoter);
					return ResponseEntity.status(204).build();
				})
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Não existe aqui Féra!");
				});
	}
	
}
