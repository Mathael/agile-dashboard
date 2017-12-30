package com.dashboard.controller;

import com.dashboard.api.services.UserService;
import com.dashboard.core.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LEBOC Philippe
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test/{username}", method = RequestMethod.GET)
    public int createUser(@PathVariable("username") String username) {
        final User user = new User(username, "123456789");
        final User u = userService.save(user);
        return u.getId();
    }
}
