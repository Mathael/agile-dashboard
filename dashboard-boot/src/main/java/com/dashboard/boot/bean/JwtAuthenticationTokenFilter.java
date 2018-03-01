package com.dashboard.boot.bean;

import com.dashboard.api.services.UserService;
import com.dashboard.api.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leboc Philippe.
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final String WARN_CANNOT_RETRIEVE_TOKEN_INFORMATIONS = "Cannot retrieve username from token";
    private static final String WARN_TOKEN_EXPIRED_AND_NOT_VALID = "The token is expired and not valid anymore";

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Value("${application.auth.jwt.header}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String requestHeader = request.getHeader(this.tokenHeader);

        String username = null;
        String authToken = null;

        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                log.warn(WARN_CANNOT_RETRIEVE_TOKEN_INFORMATIONS, e);
            } catch (ExpiredJwtException e) {
                log.warn(WARN_TOKEN_EXPIRED_AND_NOT_VALID, e);
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            final UserDetails userDetails = this.userService.loadUserByUsername(username);
            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}