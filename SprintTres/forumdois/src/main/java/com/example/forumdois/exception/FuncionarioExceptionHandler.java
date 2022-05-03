//package com.example.forumdois.exception;
//
//
//import com.example.forumdois.response.ErrorMessage;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.Date;
//
//@ControllerAdvice
//public class FuncionarioExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request){
//        String errorDescription = e.getLocalizedMessage();//pega somente a descrição deste erro
//        if(errorDescription==null) errorDescription=e.toString();//pega o tostring do objeto
//        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorDescription);
//        return new ResponseEntity<>(e, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(value = {Exception.class})
//    public final ResponseEntity<Object> NotFoundException(Exception e, WebRequest webRequest){
//
//       String errorDescription = e.getLocalizedMessage();//pega somente a descrição deste erro
//
//       if(errorDescription==null) errorDescription=e.toString();//pega o tostring do objeto
//
//        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorDescription);
//        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
//    }
//
//}
