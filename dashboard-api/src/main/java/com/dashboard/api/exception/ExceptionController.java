package com.dashboard.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.NoSuchAlgorithmException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author Leboc Philippe.
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(code = INTERNAL_SERVER_ERROR, reason = "Cannot find algorithm to be used")
    @ExceptionHandler(NoSuchAlgorithmException.class)
    public void noSuchAlgorithmException() {
        log.error("noSuchAlgorithmException");
    }

}
