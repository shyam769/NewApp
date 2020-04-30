package com.example.test.DemoMicroservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityExcptionHandler  extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),ex.getMessage(),request.getDescription(false));

       return  new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFounfByIdExcepton.class)
    public final ResponseEntity<Object> handleUserNotfoundException(Exception ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),"UserNotfoundBy"+ex.getMessage(),request.getDescription(false));

        return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFounfByNameExcept.class)
    public final ResponseEntity<Object> handleUserNotfoundByNameException(Exception ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),"UserNotfoundBy"+ex.getMessage(),request.getDescription(false));

        return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
