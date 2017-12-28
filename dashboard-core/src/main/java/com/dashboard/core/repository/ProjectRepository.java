package com.dashboard.core.repository;

import com.dashboard.core.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leboc Philippe.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
}
