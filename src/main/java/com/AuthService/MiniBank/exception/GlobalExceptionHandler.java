package com.AuthService.MiniBank.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            EmailAlreadyExistsException.class)
    public ResponseEntity<?> handleEmailException(
            EmailAlreadyExistsException ex) {

        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(
            Exception ex) {

        return ResponseEntity
                .internalServerError()
                .body(ex.getMessage());
    }
}