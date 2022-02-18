package com.votabrasil.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe responsavel por representar uma entidade no banco
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

	private @Id Long idUser;
	private String name;
	private String email;
	private String password;

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
