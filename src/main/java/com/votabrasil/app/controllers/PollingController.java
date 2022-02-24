package com.votabrasil.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.votabrasil.app.dtos.CandidateDashboardDTO;
import com.votabrasil.app.repositories.PollingRepository;

/**
 * Class controller of operations from Polling
 * 
 * @author Boaz
 * @since 23/02/2022
 * @version 0.0.1
 *
 */
@RestController
@RequestMapping("/api/v1/polls")
public class PollingController {
	
	private @Autowired PollingRepository repository;

	@GetMapping("/candidate/dashboard")
	public ResponseEntity<List<CandidateDashboardDTO>> getDash(){
		return ResponseEntity.ok(repository.getDashCandidate());
	}
	
}
