package com.dashboard.api.exception.security;

/**
 * @author LEBOC Philippe
 */
public class InvalidEncryptionKeyException extends RuntimeException {

    /**
     * The general constructor
     * @param message The display message
     */
    public InvalidEncryptionKeyException(String message) {
        super(message);
    }

    /**
     * Additionnal useful constructor
     * @param message The display message
     * @param cause The throwable cause
     */
    public InvalidEncryptionKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}
