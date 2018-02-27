package com.dashboard.core.model.ticket;

import com.dashboard.core.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @GeneratedValue
    private int id;

    private Duration duration;

    private Instant recordDate;

    @NotNull
    @ManyToOne
    private User user;

    @ManyToOne
    private Ticket ticket;
}
