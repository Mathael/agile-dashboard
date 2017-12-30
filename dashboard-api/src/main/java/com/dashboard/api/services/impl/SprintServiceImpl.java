package com.dashboard.api.services.impl;

import com.dashboard.api.services.SprintService;
import com.dashboard.core.model.project.Sprint;
import com.dashboard.core.repository.SprintRepository;
import org.springframework.stereotype.Service;

/**
 * @author Leboc Philippe.
 */
@Service
public class SprintServiceImpl extends DefaultServiceImpl<Sprint, Integer, SprintRepository> implements SprintService {
}
