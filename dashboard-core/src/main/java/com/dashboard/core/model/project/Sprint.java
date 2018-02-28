package com.dashboard.core.model.project;

import com.dashboard.core.model.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Table(name = "sprints")
public class Sprint {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String label;

    @Size(max = 500)
    private String description;

    @NotNull
    @ManyToOne
    private Project project;

    @OneToMany
    private List<Ticket> tickets;
}
