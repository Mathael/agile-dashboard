package com.dashboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author Leboc Philippe.
 */
@RestControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(ConstraintViolationException.class)
    public String conflict() {
        return "Constraint violation";
    }

}
