package com.example.demo.exception;

/**
 * Exception for handling unauthorized access.
 */
public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super(message); // Passes the error message to RuntimeException
    }
}
