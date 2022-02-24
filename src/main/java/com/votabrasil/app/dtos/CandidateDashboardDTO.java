package com.votabrasil.app.dtos;

/**
 * Interface responsible for DTO dashboard candidate.
 * 
 * @author Gustavo Boaz
 * @since 23/02/2022
 * @version 1.0
 * 
 */
public interface CandidateDashboardDTO {

    // Getters
    public String getName();

    public String getType_post();

    public String getParty();

    public String getNumber();

    public String getPhoto();

    public Long getVotes();
    
}
