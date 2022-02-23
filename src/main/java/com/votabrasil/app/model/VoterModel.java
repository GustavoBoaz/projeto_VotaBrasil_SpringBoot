package com.votabrasil.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class persistence of VoterModel
 * 
 * @author Marcelo
 * @author Boaz
 * @since 18/02/2022
 * @version 0.0.1
 *
 */
@Entity
@Table(name = "tb_voters")
public class VoterModel {

	// System generated
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idVoter;
	
	// User Generated
	private String name;
	private String email;
	private String password;
	
	// Constructors
	public VoterModel() {
		super();
	}

	public VoterModel(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public VoterModel(Long idVoter, String name, String email, String password) {
		super();
		this.idVoter = idVoter;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getters and Setters
	public Long getIdVoter() {
		return idVoter;
	}

	public void setIdVoter(Long idVoter) {
		this.idVoter = idVoter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
