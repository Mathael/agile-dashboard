package com.dashboard.api.services.impl;

import com.dashboard.api.services.TicketService;
import com.dashboard.core.model.ticket.Ticket;
import com.dashboard.core.repository.TicketRepository;
import org.springframework.stereotype.Service;

/**
 * @author Leboc Philippe.
 */
@Service
public class TicketServiceImpl extends DefaultServiceImpl<Ticket, Integer, TicketRepository> implements TicketService {
}
