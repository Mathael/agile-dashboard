package com.dashboard.dto;

import com.dashboard.core.model.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author LEBOC Philippe
 */
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class AuthDto {

    private String token;
    private UserDto user;

    /**
     * Conversion to DTO
     * @param token The given token
     * @param user The given user
     */
    public AuthDto(String token, User user) {
        this(token, new UserDto(user));
    }
}
