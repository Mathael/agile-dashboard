package com.dashboard.core.model.corporation;

import com.dashboard.core.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author LEBOC Philippe
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "corporation_access")
public class CorporationAccess {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @ManyToOne
    private Corporation corporation;

    @ManyToMany
    private List<User> grantedUsers;
}
