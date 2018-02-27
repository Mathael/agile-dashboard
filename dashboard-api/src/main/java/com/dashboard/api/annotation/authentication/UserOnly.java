package com.dashboard.api.annotation.authentication;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author LEBOC Philippe
 */
@PreAuthorize("hasRole('ROLE_USER')")
@Target({ METHOD, TYPE })
@Retention(RUNTIME)
public @interface UserOnly {
}
