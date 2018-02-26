package com.dashboard.core.validation.annotation;

import com.dashboard.core.validation.validator.PasswordValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Leboc Philippe.
 */
@Documented
@Target({ METHOD, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface Password {
}
