//  Aux class for handling error
package com.example.demo.exception;

/**
 * Exception for handling cases where username already exists during registration.
 */
public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String message) {
        super(message); // Passes the error message to RuntimeException
    }
}
