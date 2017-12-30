package com.dashboard.core.repository;

import com.dashboard.core.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leboc Philippe.
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
