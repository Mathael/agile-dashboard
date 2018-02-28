package com.dashboard.api.exception.security;

/**
 * @author LEBOC Philippe
 */
public class AlgorithmNotFoundException extends RuntimeException {

    /**
     * The general constructor
     * @param message The display message
     */
    public AlgorithmNotFoundException(String message) {
        super(message);
    }

    /**
     * Additionnal useful constructor
     * @param message The display message
     * @param cause The throwable cause
     */
    public AlgorithmNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
