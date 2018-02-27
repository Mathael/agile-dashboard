package com.dashboard.core.model.corporation;

import com.dashboard.core.model.project.Project;
import com.dashboard.core.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
@Table(name = "corporation", uniqueConstraints = {
    @UniqueConstraint(columnNames = "name")
})
public class Corporation {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(min = 8, max = 30)
    private String name;

    @NotEmpty
    @OneToMany
    private List<User> members;

    @NotNull
    @OneToMany
    private List<Project> projects;

    @OneToMany
    private List<CorporationAccess> accessList;
}
