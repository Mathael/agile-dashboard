package com.dashboard.api.services.impl;

import com.dashboard.api.services.ProjectService;
import com.dashboard.core.model.project.Project;
import com.dashboard.core.repository.ProjectRepository;
import org.springframework.stereotype.Service;

/**
 * @author Leboc Philippe.
 */
@Service
public class ProjectServiceImpl extends DefaultServiceImpl<Project, Integer, ProjectRepository> implements ProjectService {
}
