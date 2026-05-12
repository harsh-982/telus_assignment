package com.telus.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for application-level exceptions.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles invalid transaction related exceptions.
     *
     * @param ex exception instance
     * @return error response with BAD_REQUEST status
     */
    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<String> handleInvalidTransaction(
            InvalidTransactionException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }
}
