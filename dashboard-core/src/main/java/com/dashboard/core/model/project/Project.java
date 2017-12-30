package com.dashboard.core.model.project;

import com.dashboard.core.model.ticket.TicketSeverity;
import com.dashboard.core.model.user.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String label;

    @Size(max = 500)
    private String description;

    @OneToMany
    private List<Sprint> sprints;

    @OneToMany
    private List<TicketSeverity> ticketSeverities;

    @ManyToMany
    private List<UserGroup> userGroups;
}
