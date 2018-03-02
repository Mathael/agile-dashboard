package com.dashboard.controller;

import com.dashboard.api.bean.Response;
import com.dashboard.api.services.UserService;
import com.dashboard.api.util.JwtUtil;
import com.dashboard.core.model.user.User;
import com.dashboard.dto.AuthDto;
import com.dashboard.dto.UserDto;
import com.dashboard.request.AuthenticationRequest;
import com.dashboard.request.UserCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author LEBOC Philippe
 */
@Validated
@RestController
@RequestMapping(value = "/api/auth", produces = APPLICATION_JSON_UTF8_VALUE)
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "/signup", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public Response signup(@Valid @RequestBody UserCreationRequest request) {
        final User user = userService.create(request.getUsername(), request.getEmail(), request.getPassword());
        final String token = jwtTokenUtil.generateToken(user);
        return new Response(new AuthDto(token, new UserDto(user)));
    }

    @RequestMapping(value = "/login", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public Response login(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        // Perform the security
        final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        final Authentication authentication = authenticationManager.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final User user = userService.loadUserByEmail(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(user);

        // Return the token
        return new Response(new AuthDto(token, new UserDto(user)));
    }
}
