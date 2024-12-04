//  Aux class for handling error
package com.example.demo.exception;

/**
 * Exception for handling invalid login credentials.
 */
public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message); // Passes the error message to RuntimeException
    }
}
