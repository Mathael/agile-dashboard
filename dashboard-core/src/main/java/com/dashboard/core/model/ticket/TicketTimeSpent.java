package com.dashboard.core.model.ticket;

import com.dashboard.core.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Duration;
import java.time.Instant;

/**
 * @author Leboc Philippe.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_time_spent")
public class TicketTimeSpent {

    @Id
    private int id;

    private Duration duration;

    private Instant recordDate;

    private User user;
}
