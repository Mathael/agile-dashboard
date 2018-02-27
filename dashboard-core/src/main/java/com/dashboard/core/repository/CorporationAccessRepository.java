package com.dashboard.core.repository;

import com.dashboard.core.model.corporation.CorporationAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LEBOC Philippe
 */
@Repository
public interface CorporationAccessRepository extends JpaRepository<CorporationAccess, Integer> {
}
