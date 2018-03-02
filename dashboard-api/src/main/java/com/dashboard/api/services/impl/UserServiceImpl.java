package com.dashboard.api.services.impl;

import com.dashboard.api.exception.UserEmailAlreadyExistException;
import com.dashboard.api.exception.UserNotFoundException;
import com.dashboard.api.exception.UserUsernameAlreadyExistException;
import com.dashboard.api.services.UserService;
import com.dashboard.core.model.user.User;
import com.dashboard.core.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author Leboc Philippe.
 */
@Service
@Validated
public class UserServiceImpl extends DefaultServiceImpl<User, Integer, UserRepository> implements UserService {

    @Override
    public UserDetails loadUserByUsername(final String s) {
        final UserDetails user = repository.findByUsername(s);
        if(user == null) {
            throw new UsernameNotFoundException("User [" + s + "] not found");
        }
        return user;
    }

    @Override
    public User loadUserByEmail(final String email) {
        final User user = repository.findByEmail(email);
        if(user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public User create(final String username, final String email, final String password) {
        User user = repository.findByUsername(username);
        if(user != null) {
            throw new UserUsernameAlreadyExistException();
        }

        user = repository.findByEmail(email);
        if(user != null) {
            throw new UserEmailAlreadyExistException();
        }

        return repository.save(new User(username, password, email));
    }
}
