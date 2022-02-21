package com.votabrasil.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votabrasil.app.model.UserModel;
import com.votabrasil.app.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	private @Autowired UserRepository repository;
	
	@GetMapping
	public List<UserModel> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public UserModel getById(@PathVariable(value = "id") Long idUser) {
		return repository.findById(idUser).get();
	}

}
