package com.example.test.DemoMicroservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFounfByNameExcept extends RuntimeException{

    public UserNotFounfByNameExcept(String ms){
        super(ms);
    }
}
