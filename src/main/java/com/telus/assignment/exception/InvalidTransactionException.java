package com.telus.assignment.exception;

public class InvalidTransactionException extends RuntimeException {

    /**
     * Custom exception for invalid transaction data.
     */
    public InvalidTransactionException(String message) {
        super(message);
    }
}
