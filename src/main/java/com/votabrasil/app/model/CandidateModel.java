package com.votabrasil.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private @Enumerated(EnumType.STRING) CandidateType typePost;
	private String name;
	private String cpf;
	private String party;
	private String number;
	private String photo;

	// Relationship
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"candidate"})
	private List<PollingModel> votesReceived = new ArrayList<>();

	// Constructors
	public CandidateModel() {
		super();
	}

	public CandidateModel(CandidateType typePost, String name, String cpf, String party, String number, String photo) {
		super();
		this.typePost = typePost;
		this.name = name;
		this.cpf = cpf;
		this.party = party;
		this.number = number;
		this.photo = photo;
	}

	public CandidateModel(Long idCandidate, CandidateType typePost, String name, String cpf, String party, String number, String photo) {
		super();
		this.idCandidate = idCandidate;
		this.typePost = typePost;
		this.name = name;
		this.cpf = cpf;
		this.party = party;
		this.number = number;
		this.photo = photo;
	}

	// Getters and Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<PollingModel> getVotesReceived() {
		return votesReceived;
	}

	public void setVotesReceived(List<PollingModel> votesReceived) {
		this.votesReceived = votesReceived;
	}

	public static enum CandidateType {
		PRESIDENTE, DEPUTADO_ESTADUAL, DEPUTADO_FEDERAL, SENADOR, GOVERNADOR
	}

}
