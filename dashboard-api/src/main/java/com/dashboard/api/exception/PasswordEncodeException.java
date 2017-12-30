package com.dashboard.api.exception;

/**
 * @author Leboc Philippe.
 */
public class PasswordEncodeException extends RuntimeException {

    /**
     * @param message The exception message
     */
    public PasswordEncodeException(String message) {
        super(message);
    }

    /**
     * @param message The exception message
     * @param cause The exception cause
     */
    public PasswordEncodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
