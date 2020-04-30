package com.example.test.DemoMicroservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFounfByIdExcepton extends RuntimeException {
    public UserNotFounfByIdExcepton(String message){
        super(message);
    }
}
