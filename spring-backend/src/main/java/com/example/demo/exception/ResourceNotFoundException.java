package com.example.demo.exception;

/**
 * Exception for handling cases where requested resource is not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message); // Passes the error message to RuntimeException
    }
}
