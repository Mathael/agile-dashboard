package com.dashboard.api.services;

import com.dashboard.core.model.user.User;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Leboc Philippe.
 */
public interface UserService extends DefaultService<User, Integer>, UserDetailsService {
}
