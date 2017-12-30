package com.dashboard.core.model.user;

import com.dashboard.core.model.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Leboc Philippe.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usergroups")
public class UserGroup {

    @Id
    private int id;

    @NotEmpty
    private String label;

    @ManyToMany
    private List<User> users;

    @ManyToMany
    private List<Project> projects;
}
