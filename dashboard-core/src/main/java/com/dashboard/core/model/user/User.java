package com.dashboard.core.model.user;

import com.dashboard.core.model.corporation.Corporation;
import com.dashboard.core.model.corporation.CorporationAccess;
import com.dashboard.core.model.ticket.TicketTimeSpent;
import com.dashboard.core.validation.annotation.Username;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * @author Leboc Philippe
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private int id;

    @Username
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank
    @Size(min = 8)
    private String password;

    @Email
    @NotNull
    private String email;

    @ManyToMany
    private List<UserGroup> groups;

    @ManyToOne
    private Corporation corporation;

    @ManyToMany
    private List<CorporationAccess> accesses;

    @OneToMany
    private List<TicketTimeSpent> ticketTimeSpents;

    /**
     * Default constructor
     * @param username The given username
     * @param password The given password
     * @param email The given email address
     */
    public User(String username, String password, String email) {
        this(-1, username, password, email, emptyList(), null, emptyList(), emptyList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return singletonList(() -> "USER");
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
