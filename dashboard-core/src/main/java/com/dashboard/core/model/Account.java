package com.dashboard.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Leboc Philippe.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @NotNull
    @Size(min = 4, max = 16)
    private String login;

    @NotNull
    @Size(min = 6, max = 28)
    private String password;

    private String email;

    private long created_time;

    private long lastActive = 0;

    @Range(min = 0, max = 8)
    private int accessLevel = 0;

    public Account(String login, String password, int accessLevel) {
        this(login, password, null, 0, 0, accessLevel);
    }
}
