package com.example.forumdois.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ControllerAdvice
public class ErrorMessage  extends ResponseEntityExceptionHandler {

    private Date currentDate;
    private String message;


}
