package com.example.game.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomerNotNullException.class) // CustomerNotNullException throwlandığı zaman bunun çalışacağı anlamına geliyor
    public ResponseEntity<?> customerNotNull(CustomerNotNullException customerNotNullException)
    {
        List<String> detail = new ArrayList<>();
        detail.add(customerNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("CustomerNotNull",detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
