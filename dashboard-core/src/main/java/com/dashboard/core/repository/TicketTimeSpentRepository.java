package com.dashboard.core.repository;

import com.dashboard.core.model.ticket.TicketTimeSpent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leboc Philippe.
 */
@Repository
public interface TicketTimeSpentRepository extends JpaRepository<TicketTimeSpent, Integer> {
}
