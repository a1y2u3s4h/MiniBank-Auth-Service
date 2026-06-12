package com.AuthService.MiniBank.exception;

public class EmailAlreadyExistsException
        extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}