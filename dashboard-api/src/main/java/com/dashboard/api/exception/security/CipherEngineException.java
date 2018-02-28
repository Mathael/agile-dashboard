package com.dashboard.api.exception.security;

/**
 * @author LEBOC Philippe
 */
public class CipherEngineException extends RuntimeException {

    /**
     * The general constructor
     * @param message The display message
     */
    public CipherEngineException(String message) {
        super(message);
    }

    /**
     * Additionnal useful constructor
     * @param message The display message
     * @param cause The throwable cause
     */
    public CipherEngineException(String message, Throwable cause) {
        super(message, cause);
    }
}
