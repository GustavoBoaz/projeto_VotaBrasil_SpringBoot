package com.votabrasil.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class persistence of UserModel
 * 
 * @author Marcelo
 * @author Boaz
 * @since 18/02/2022
 * @version 0.0.1
 *
 */
@Entity
@Table(name = "tb_users")
public class UserModel {

	// System generated
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUser;
	
	// User Generated
	private String name;
	private String email;
	private String password;
	
	// Constructors
	public UserModel() {
		super();
	}

	public UserModel(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserModel(Long idUser, String name, String email, String password) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getters and Setters
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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
