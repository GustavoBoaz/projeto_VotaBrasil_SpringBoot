package com.votabrasil.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.votabrasil.app.model.PollingModel;

/**
 * PollingRepository responsible for CRUD operations on PollingModel
 * 
 * @author Boaz
 * @since 23/02/2022
 * @version 1.0
 * 
 */
@Repository
public interface PollingRepository extends JpaRepository<PollingModel, String> {

}
