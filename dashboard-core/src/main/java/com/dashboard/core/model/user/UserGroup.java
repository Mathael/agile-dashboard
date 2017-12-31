package com.dashboard.core.model.user;

import com.dashboard.core.model.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

import static java.util.Collections.emptyList;

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
    @GeneratedValue
    private int id;

    @NotEmpty
    private String label;

    @Size(max = 1000)
    private String description;

    @ManyToMany
    private List<User> users;

    @ManyToMany
    private List<Project> projects;

    public UserGroup(String label, String description) {
        this(-1, label, description, emptyList(), emptyList());
    }
}
