package com.dashboard.api.services.impl;

import com.dashboard.api.services.TicketTimeSpentService;
import com.dashboard.core.model.ticket.TicketTimeSpent;
import com.dashboard.core.repository.TicketTimeSpentRepository;
import org.springframework.stereotype.Service;

/**
 * @author Leboc Philippe.
 */
@Service
public class TicketTimeSpentServiceImpl extends DefaultServiceImpl<TicketTimeSpent, Integer, TicketTimeSpentRepository> implements TicketTimeSpentService {
}
