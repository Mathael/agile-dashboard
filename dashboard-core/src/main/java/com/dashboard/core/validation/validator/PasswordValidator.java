package com.dashboard.core.validation.validator;

import com.dashboard.core.validation.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Clear text password validation
 * - Not null
 * - Not blank
 * - Not whitespace
 * - Min size = 8 (inclusive)
 * - Max size = 30 (inclusive)
 * @author Leboc Philippe
 */
public class PasswordValidator implements ConstraintValidator<Password, CharSequence> {

    private static final int MIN_SIZE = 8;
    private static final int MAX_SIZE = 30;

    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {
        if(value == null) {
            return false;
        }

        final String str = value.toString().trim();
        return !str.isEmpty() && str.length() >= MIN_SIZE && str.length() <= MAX_SIZE;
    }
}
