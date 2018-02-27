package com.dashboard.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Disable Sonar analisys for the whole file
 * @author LEBOC Philippe
 */
@Retention(SOURCE)
@Target({TYPE})
public @interface DisableSonar {
}
