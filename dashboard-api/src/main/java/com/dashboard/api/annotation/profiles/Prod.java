package com.dashboard.api.annotation.profiles;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author LEBOC Philippe
 */
@Profile({"prod"})
@Documented
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface Prod {
}
