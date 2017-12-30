package com.dashboard.core.model.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Leboc Philippe.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_severities")
public class TicketSeverity {

    @Id
    private int id;

    @NotEmpty
    private String label;

    private String description;

    @NotEmpty
    private String color;
}
