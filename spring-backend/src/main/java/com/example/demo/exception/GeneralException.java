package com.example.demo.exception;

/**
 * General exception for handling uncategorized errors.
 */
public class GeneralException extends RuntimeException {
    public GeneralException(String message) {
        super(message); // Passes the error message to RuntimeException
    }
}
