package com.votabrasil.app.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.votabrasil.app.dtos.VoterRegisterDTO;
import com.votabrasil.app.model.VoterModel;
import com.votabrasil.app.repositories.VoterRepository;
import com.votabrasil.app.services.VoterServices;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsuarioControllerTest {
	
	private @Autowired TestRestTemplate testRestTemplate;
	private @Autowired VoterServices services;
	private @Autowired VoterRepository repository;

	@BeforeAll
	void start() {
		repository.deleteAll();
	}
	
	@Test
	@Order(1)
	@DisplayName("Teste Post Usuario")
	void createUserReturn201() {
		
		//GIVEN
		HttpEntity<VoterRegisterDTO> request = new HttpEntity<VoterRegisterDTO>(
				new VoterRegisterDTO("Dharan Boaz", "412.841.048-93", "dharan@email.com", "134652"));
		
		//WHEN
		ResponseEntity<VoterModel> responses = testRestTemplate
				.exchange("/api/v1/voters", HttpMethod.POST, request, VoterModel.class);
		
		//THEN
		assertEquals(HttpStatus.CREATED, responses.getStatusCode());
		
	}

}
