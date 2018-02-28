package com.dashboard.api.exception.security;

/**
 * @author LEBOC Philippe
 */
public class EncryptEmptyStrException extends RuntimeException {

    /**
     * The general constructor
     * @param message The display message
     */
    public EncryptEmptyStrException(String message) {
        super(message);
    }

    /**
     * Additionnal useful constructor
     * @param message The display message
     * @param cause The throwable cause
     */
    public EncryptEmptyStrException(String message, Throwable cause) {
        super(message, cause);
    }
}
