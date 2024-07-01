package com.example.currencyrate.handler;

import com.example.currencyrate.entity.Error;
import com.example.currencyrate.handler.exception.CurrencyCodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler{

    @ExceptionHandler(CurrencyCodeNotFoundException.class)
    public ResponseEntity<?> handleExceptionUniqueMessage(Exception e) {
        return new ResponseEntity<>(Error.builder()
                .code(1)
                .message(e.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}