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

import com.votabrasil.app.model.CandidateModel;
import com.votabrasil.app.repositories.CandidateRepository;

/**
 * Class controller of operations from Candidate
 * 
 * @author Boaz
 * @since 23/02/2022
 * @version 0.0.1
 *
 */
@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {

	private @Autowired CandidateRepository repository;
	
	@GetMapping
	public List<CandidateModel> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CandidateModel> getById(@PathVariable(value = "id") Long idCandidate) {
		return repository.findById(idCandidate)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Não existe aqui Féra!");
				});
	}
	
	@PostMapping
	public ResponseEntity<CandidateModel> save(@RequestBody CandidateModel candidate) {
		return ResponseEntity.status(201).body(repository.save(candidate));
	}
	
	@PutMapping
	public ResponseEntity<CandidateModel> update(@RequestBody CandidateModel candidate) {
		return repository.findById(candidate.getIdCandidate())
				.map(resp -> ResponseEntity.status(200).body(repository.save(candidate)))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não encontrado");
				});
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable(value = "id") Long idCandidate) {
		return repository.findById(idCandidate)
				.map(resp -> {
					repository.deleteById(idCandidate);
					return ResponseEntity.status(204).build();
				})
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Não existe aqui Féra!");
				});
	}
	
}
