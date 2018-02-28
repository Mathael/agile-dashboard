package com.dashboard.api.services.impl;

import com.dashboard.api.services.CorporationService;
import com.dashboard.core.model.corporation.Corporation;
import com.dashboard.core.repository.CorporationRepository;
import org.springframework.stereotype.Service;

/**
 * @author LEBOC Philippe
 */
@Service
public class CorporationServiceImpl extends DefaultServiceImpl<Corporation, Integer, CorporationRepository> implements CorporationService {
}
