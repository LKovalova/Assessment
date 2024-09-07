package com.example.smarthome.exception;

/**
 * Custom exception for handling appliance-related errors.
 */
public class ApplianceException extends RuntimeException {
    public ApplianceException(String message) {
        super(message);
    }
}