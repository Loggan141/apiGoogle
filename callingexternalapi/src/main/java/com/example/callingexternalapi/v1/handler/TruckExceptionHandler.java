package com.example.callingexternalapi.v1.handler;

import com.example.callingexternalapi.v1.exception.ExceptionDetails;
import com.example.callingexternalapi.v1.exception.TruckNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice

public class TruckExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TruckNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleTruckNotFound(TruckNotFoundException e){
        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Bad Request : NOT FOUND")
                .detail(e.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Truck not found")
                .developerMessage(e.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);

    }
}
