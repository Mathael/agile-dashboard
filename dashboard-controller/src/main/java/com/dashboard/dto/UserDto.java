package com.dashboard.dto;

import com.dashboard.core.model.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Leboc Philippe.
 */
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class UserDto {

    private int id;
    private String username;
    private String email;

    public UserDto(User user) {
        this(user.getId(), user.getUsername(), user.getEmail());
    }
}
