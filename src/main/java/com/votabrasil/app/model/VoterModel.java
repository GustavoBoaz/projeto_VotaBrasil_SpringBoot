package com.votabrasil.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String cpf;
	private String email;
	private String password;

	@OneToMany(mappedBy = "voter", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"voter"})
	private List<PollingModel> myPolls = new ArrayList<>();

	// Constructors
	public VoterModel() {
		super();
	}

	public VoterModel(String name, String cpf, String email, String password) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
	}

	public VoterModel(Long idVoter, String name, String cpf, String email, String password) {
		super();
		this.idVoter = idVoter;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
	}

	// Getters and Setters
	public Long getIdVoter() {
		return idVoter;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public List<PollingModel> getMyPolls() {
		return myPolls;
	}

	public void setMyPolls(List<PollingModel> myPolls) {
		this.myPolls = myPolls;
	}

}
