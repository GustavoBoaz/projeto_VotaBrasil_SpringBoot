package com.votabrasil.app.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.votabrasil.app.model.VoterModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
class VoterRepositoryTest {
	
	private @Autowired VoterRepository repository;
	
	
	// GIVEN que eu tenho dharan@email no banco
	// WHEN eu pesquiso por dharan@email
	// THEN ele me retorna dharan@email
	
	@BeforeAll
	void start() {
		repository.deleteAll();
		
		//GIVEN
		repository.save(new VoterModel("Dharan Boaz", "111.111.111-11", "dharan@email.com", "134652"));
		repository.save(new VoterModel("Giovanna Boaz", "222.222.222-22", "giovanna@email.com", "134652"));
		repository.save(new VoterModel("Italo Boaz", "333.333.333-33", "italo@email.com", "134652"));
		
	}
	
	@Test
	@DisplayName("Teste FindByEmail")
	void searchValidEmailReturnTrue() {
		//WHEN
		Optional<VoterModel> optional = repository.findByEmail("dharan@email.com");
		
		//THEN
		assertTrue("dharan@email.com" == optional.get().getEmail());
	}
	
	@Test
	@DisplayName("Teste FindAll")
	void searchAllReturnTreeVoters() {
		//WHEN
		List<VoterModel> list = repository.findAll();
		
		//THEN
		assertEquals(3, list.size());
		assertTrue(list.get(0).getEmail().equals("dharan@email.com"));
		
	}

}
