package com.votabrasil.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

/**
 * Interface responsible for the validation register of the user.
 * 
 * @author Boaz
 * @since 07/03/2022
 * @version 1.0
 */
public class VoterRegisterDTO {

	private @NotBlank String name;
	private @NotBlank @CPF String cpf;
	private @NotBlank @Email String email;
	private @NotBlank String password;
	
	public VoterRegisterDTO() {
		super();
	}

	public VoterRegisterDTO(String name, String cpf, String email,String password) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
