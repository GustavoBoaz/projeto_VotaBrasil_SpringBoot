package com.votabrasil.app.security;

import java.util.Optional;

import com.votabrasil.app.model.VoterModel;
import com.votabrasil.app.repositories.VoterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplement implements UserDetailsService  {

    private @Autowired VoterRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<VoterModel> optional = repository.findByEmail(username);

        if (optional.isPresent()) {
            return new UserDetailsImplement(optional.get());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

}
