package com.dashboard.controller;

import com.dashboard.api.bean.Response;
import com.dashboard.api.services.UserService;
import com.dashboard.core.model.user.User;
import com.dashboard.dto.UserDto;
import com.dashboard.request.UserCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author LEBOC Philippe
 */
@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = POST)
    public Response createUser(@RequestBody UserCreationRequest request) {
        return new Response(userService.save(new User(request.getUsername(), request.getPassword(), request.getEmail())));
    }

    @RequestMapping(method = GET)
    public Response findAll() {
        return new Response(userService.findAll().stream().map(UserDto::new).collect(toList()));
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Response findById(@PathVariable("id") int id) {
        return new Response(userService.find(id));
    }
}
