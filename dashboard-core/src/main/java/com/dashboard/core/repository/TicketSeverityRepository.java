package com.dashboard.core.repository;

import com.dashboard.core.model.ticket.TicketSeverity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leboc Philippe.
 */
@Repository
public interface TicketSeverityRepository extends JpaRepository<TicketSeverity, Integer> {
}
