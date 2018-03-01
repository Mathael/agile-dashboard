package com.dashboard.api.services.impl;

import com.dashboard.api.services.UserService;
import com.dashboard.core.model.user.User;
import com.dashboard.core.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Leboc Philippe.
 */
@Service
public class UserServiceImpl extends DefaultServiceImpl<User, Integer, UserRepository> implements UserService {

    @Override
    public UserDetails loadUserByUsername(final String s) {
        final UserDetails user = repository.findByUsername(s);
        if(user == null) {
            throw new UsernameNotFoundException("User [" + s + "] not found");
        }
        return user;
    }
}
