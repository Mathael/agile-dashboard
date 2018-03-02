package com.dashboard.api.services;

import com.dashboard.api.exception.UserEmailAlreadyExistException;
import com.dashboard.api.exception.UserNotFoundException;
import com.dashboard.api.exception.UserUsernameAlreadyExistException;
import com.dashboard.core.model.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Leboc Philippe.
 */
public interface UserService extends DefaultService<User, Integer>, UserDetailsService {

    /**
     * Load User from database
     * @param email The given user email address
     * @return The user bound to the given email address
     * @throws UserNotFoundException when the requested user not found for the given email address
     * @throws ConstraintViolationException when parameter is not blank or email address formatted
     */
    User loadUserByEmail(final @NotBlank @Email String email);

    /**
     * Create new User in database
     * @param username The given User username
     * @param email The given User email address
     * @param password The given User password
     * @return The new User
     * @throws ConstraintViolationException when any parameter does not match requirements
     * @throws UserUsernameAlreadyExistException when the username is already bound to another User
     * @throws UserEmailAlreadyExistException when the email address is already bound to another User
     */
    User create(final @NotBlank String username, final @NotBlank @Email String email, final @NotBlank String password);
}
