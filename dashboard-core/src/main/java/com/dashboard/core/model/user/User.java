package com.dashboard.core.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * @author Leboc Philippe.
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

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Size(min = 8)
    private String password;

    @Email
    @NotNull
    private String email;

    @ManyToMany
    private List<UserGroup> groups;

    public User(String username, String password, String email) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setGroups(emptyList());
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
