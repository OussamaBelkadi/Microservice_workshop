package com.example.simple_restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
    // /hello-world
    @RequestMapping(method = RequestMethod.GET, path = "/hello-word")
    public String helloWord(){
        return "Hello World";
    }
}
