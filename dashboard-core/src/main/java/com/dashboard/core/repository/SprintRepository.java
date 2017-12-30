package com.dashboard.core.repository;

import com.dashboard.core.model.project.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leboc Philippe.
 */
@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer> {
}
