package com.votabrasil.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public ResponseEntity<UserModel> getById(@PathVariable(value = "id") Long idUser) {
		return repository.findById(idUser)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Não existe aqui Féra!");
				});
	}
	
	@PostMapping
	public ResponseEntity<UserModel> save(@RequestBody UserModel user) {
		return ResponseEntity.status(201).body(repository.save(user));
	}
	
	@PutMapping
	public ResponseEntity<UserModel> update(@RequestBody UserModel user) {
		return repository.findById(user.getIdUser())
				.map(resp -> ResponseEntity.status(200).body(repository.save(user)))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não encontrado");
				});
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable(value = "id") Long idUser) {
		return repository.findById(idUser)
				.map(resp -> {
					repository.deleteById(idUser);
					return ResponseEntity.status(204).build();
				})
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Não existe aqui Féra!");
				});
	}
	
}
