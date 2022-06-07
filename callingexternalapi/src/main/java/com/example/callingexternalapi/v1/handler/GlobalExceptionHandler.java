package com.example.callingexternalapi.v1.handler;

import com.example.callingexternalapi.v1.exception.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.UnexpectedTypeException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
     public ResponseEntity<ExceptionDetails> handleMethodNotSupported(HttpRequestMethodNotSupportedException exception){
        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Error")
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .title("Method not supported")
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionDetails> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException exception){
        return new ResponseEntity<> (ExceptionDetails.builder()
                .title("NOT FOUND : Check the documentation")
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Something is missing")
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDetails> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception){
        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Bad Request : Not Readable")
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Something in body is wrong")
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDetails> handleNullPointerException(
            NullPointerException exception){
        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Bad Request : Null")
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Cannot be Null")
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetails> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception){
        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Bad Request : Argument Not Valid")
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Not valid argument")
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<ExceptionDetails> handleUnexpectedTypeException(
            UnexpectedTypeException exception){
        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Bad Request : Wrong Type")
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .title("Wrong type")
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDetails> handleIllegalArgumentException(
            IllegalArgumentException exception){
        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Bad Request : Invalid Argument")
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .title("Invalid Argument")
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ExceptionDetails> handleHttpMessageConversionException(
            HttpMessageConversionException exception){
        return new ResponseEntity<>(ExceptionDetails.builder()
                .title("Internal Server Error")
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title("Something in server is wrong")
                .developerMessage(exception.getClass().getName())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
