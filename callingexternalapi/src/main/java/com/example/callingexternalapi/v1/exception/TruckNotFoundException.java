package com.example.callingexternalapi.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TruckNotFoundException extends RuntimeException{
     public TruckNotFoundException(){
        super("Truck not found");
    }
}
