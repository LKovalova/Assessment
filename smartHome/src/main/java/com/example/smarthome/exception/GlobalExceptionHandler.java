package com.example.smarthome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Global exception handler for handling various exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles IllegalArgumentException.
     *
     * @param ex the exception to handle.
     * @return a response entity with error message and BAD_REQUEST status.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles ApplianceException.
     *
     * @param ex the exception to handle.
     * @return a response entity with error message and BAD_REQUEST status.
     */
    @ExceptionHandler(ApplianceException.class)
    @ResponseBody
    public ResponseEntity<String> handleApplianceException(ApplianceException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles all other exceptions.
     *
     * @param ex the exception to handle.
     * @return a response entity with a generic error message and INTERNAL_SERVER_ERROR status.
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
