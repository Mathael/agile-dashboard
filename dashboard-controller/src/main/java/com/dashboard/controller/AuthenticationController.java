package com.dashboard.controller;

import com.dashboard.api.bean.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Leboc Philippe.
 */
@RestController
@RequestMapping(value = "/api/auth", produces = APPLICATION_JSON_UTF8_VALUE)
public class AuthenticationController {

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = POST)
    public Response register() {
        return new Response();
    }

    @RequestMapping(value = "/login", method = GET)
    public Response login() {
        return new Response();
    }
}
