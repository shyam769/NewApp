package com.example.test.DemoMicroservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @GetMapping("/test")
    public String getHelloworld(){

        return "Hello World!!!!";
    }
}
