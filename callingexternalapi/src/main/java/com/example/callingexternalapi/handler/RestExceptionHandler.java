package com.example.callingexternalapi.handler;

import com.example.callingexternalapi.exception.ResourceNotFoundDetails;
import com.example.callingexternalapi.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice //permite utilizar a camada do restExceptionHandler
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException) {
        return new ResponseEntity<>(ResourceNotFoundDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rnfException.getMessage())
                .developerMessage(rnfException.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }
//
//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(
//            DefaultHandlerExceptionResolver exception){
//
//        List<FieldError> fieldErrors = exception.getBinding().
//        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
//        String fieldsMessage = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
//
//        return new ResponseEntity<>(ValidationExceptionDetails.builder()
//                        .timestamp(LocalDateTime.now())
//                        .status(HttpStatus.BAD_REQUEST.value())
//                        .title("Resource not found")
//                        //.detail(exception.getMessage())
//                        .developerMessage(exception.getClass().getName())
////                        .fields(fields)
////                        .fieldsMessage(fieldsMessage)
//                        .build(), HttpStatus.BAD_REQUEST);
//
//    }


}
