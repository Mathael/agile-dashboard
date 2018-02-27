package com.dashboard.core.repository;

import com.dashboard.core.model.corporation.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LEBOC Philippe
 */
@Repository
public interface CorporationRepository extends JpaRepository<Corporation, Integer> {
}
