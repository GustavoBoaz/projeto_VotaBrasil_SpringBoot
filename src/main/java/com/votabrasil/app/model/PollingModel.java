package com.votabrasil.app.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class persistence of PollingModel
 * 
 * @author Boaz
 * @since 23/02/2022
 * @version 0.0.1
 *
 */
@Entity
@Table(name = "tb_polls")
public class PollingModel {

	// User generated
	private @Id String cpf;

	// System generated
	private @JsonFormat(pattern = "dd/MM/yyyy") LocalDate datePolling = LocalDate.now();

	// Relationship
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"myPolls"})
	@JoinColumn(name = "voter_id")
	private VoterModel voter;

	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonIgnoreProperties({"votesReceived"})
	@JoinColumn(name = "candidate_id")
	private CandidateModel candidate;

	// Getters and Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDatePolling() {
		return datePolling;
	}

	public void setDatePolling(LocalDate datePolling) {
		this.datePolling = datePolling;
	}

	public VoterModel getVoter() {
		return voter;
	}

	public void setVoter(VoterModel voter) {
		this.voter = voter;
	}

	public CandidateModel getCandidate() {
		return candidate;
	}

	public void setCandidate(CandidateModel candidate) {
		this.candidate = candidate;
	}

}
