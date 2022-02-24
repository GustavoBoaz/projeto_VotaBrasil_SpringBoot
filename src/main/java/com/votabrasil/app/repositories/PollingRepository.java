package com.votabrasil.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.votabrasil.app.dtos.CandidateDashboardDTO;
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

    /**
     * Get Dashboard Candidate
     * 
     * @return List<CandidateDashboardDTO>
     * 
     */
    @Query(value = 
    "SELECT c.name, c.type_post, c.party, c.number, c.photo, COUNT(p.candidate_id) AS votes "
    +"FROM tb_candidates c "
    +"INNER JOIN tb_polls p ON c.id_candidate = p.candidate_id "
    +"GROUP BY c.name ORDER BY votes DESC", nativeQuery = true)
    List<CandidateDashboardDTO> getDashCandidate();
}
