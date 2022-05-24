package com.example.callingexternalapi.v1.exception;

public class TruckNotFoundException extends RuntimeException{
     TruckNotFoundException(String message){
        super(message);
    }
}
