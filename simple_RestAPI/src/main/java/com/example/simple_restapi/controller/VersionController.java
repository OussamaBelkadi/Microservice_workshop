package com.example.simple_restapi.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

public class VersionController {
//  URI Versioning
    @GetMapping(path = "app/v1")
    public String getFirstVersionOfPerson(){
        return "version 1";
    }

    @GetMapping(path = "app/v1")
    public String  getSecondVersionOfPerson(){
        return "version 2";
    }
//  Parameter Versioning

    @GetMapping(path = "app", params = "version=1")
    public String  getFirstVersionOfParams(){
        return "version 1";
    }

    @GetMapping(path = "app", params = "version=2")
    public String  getSecondVersionOfParams(){
        return "version 2";
    }
//  Header Versioning
    @GetMapping(path = "app", headers = "X-API-VERSION=2")
    public String  getSecondVersionOfHeader(){
        return "version 2";
    }

    @GetMapping(path = "app", headers = "X-API-VERSION=1")
    public String  getFirstVersionOfHeader(){
        return "version 1";
    }
//    Media type Versioning


}
