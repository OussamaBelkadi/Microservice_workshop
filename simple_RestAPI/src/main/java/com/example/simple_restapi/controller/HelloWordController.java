package com.example.simple_restapi.controller;

import com.example.simple_restapi.entity.User;
import com.example.simple_restapi.service.UserDaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class HelloWordController {
    private final UserDaoService userDaoService;

    public HelloWordController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    // /hello-world
    @RequestMapping(method = RequestMethod.GET, path = "/hello-word")
    public String helloWord(){
        return "Hello World";
    }

    @PostMapping(path = "users")
    public ResponseEntity<User> createUser(User user){
        User user1 = userDaoService.createUSer(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
