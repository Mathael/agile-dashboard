package com.dashboard.api.annotation.profiles;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Use me to disabled completely
 *
 * @author LEBOC Philippe
 */
@Profile({"!test"})
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface DisableOnTest {
}
