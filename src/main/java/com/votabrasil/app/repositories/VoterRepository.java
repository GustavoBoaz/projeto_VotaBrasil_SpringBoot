package com.votabrasil.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.votabrasil.app.model.VoterModel;

/**
 * VoterRepository responsible for CRUD operations on VoterModel
 * 
 * @author Boaz
 * @since 23/02/2022
 * @version 1.0
 */
@Repository
public interface VoterRepository extends JpaRepository<VoterModel, Long>{

}
