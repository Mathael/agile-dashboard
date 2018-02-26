package com.dashboard.api.services.impl;

import com.dashboard.api.services.UserService;
import com.dashboard.core.model.user.User;
import com.dashboard.core.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Leboc Philippe.
 */
@Service
public class UserServiceImpl extends DefaultServiceImpl<User, Integer, UserRepository> implements UserService {
    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
