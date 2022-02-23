package com.votabrasil.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class persistence of CandidateModel
 * 
 * @author Boaz
 * @since 23/02/2022
 * @version 0.0.1
 *
 */
@Entity
@Table(name = "tb_candidates")
public class CandidateModel {

	// System generated
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idCandidate;

	// ADM generated
	private CandidateType typePost;
	private String name;
	private String party;
	private String photo;

	public Long getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(Long idCandidate) {
		this.idCandidate = idCandidate;
	}

	public CandidateType getTypePost() {
		return typePost;
	}

	public void setTypePost(CandidateType typePost) {
		this.typePost = typePost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private static enum CandidateType {
		PRESIDENTE, DEPUTADO_ESTADUAL, DEPUTADO_FEDERAL, SENADOR, GOVERNADOR
	}

}
