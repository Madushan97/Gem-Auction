package com.madushan.Gem.Auction.controller;

import com.madushan.Gem.Auction.exception.UserNotFoundException;
import com.madushan.Gem.Auction.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardResponse<String>> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        StandardResponse<String> response = new StandardResponse<>(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
