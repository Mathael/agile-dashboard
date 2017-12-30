package com.dashboard.core.model.ticket;

import com.dashboard.core.model.project.Sprint;
import com.dashboard.core.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.Duration;

/**
 * @author Leboc Philippe.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String label;

    @Size(max = 1000)
    private String description;

    private Duration estimatedTime;

    @ManyToOne
    private Sprint sprint;

    private User author;
}
