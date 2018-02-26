package com.dashboard.core.validation.validator;

import com.dashboard.core.validation.annotation.Username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Username from User object validation
 * - Not null
 * - Not blank
 * - Not whitespace
 * - Min size = 4 (inclusive)
 * - Max size = 16 (inclusive)
 * @author Leboc Philippe
 */
public class UsernameValidator implements ConstraintValidator<Username, CharSequence> {

    private static final int MIN_SIZE = 4;
    private static final int MAX_SIZE = 16;

    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {
        if(value == null) {
            return false;
        }

        final String str = value.toString().trim();
        return !str.isEmpty() && str.length() >= MIN_SIZE && str.length() <= MAX_SIZE;
    }
}
