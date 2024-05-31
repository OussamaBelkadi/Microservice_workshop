package com.example.simple_restapi.controller;

import com.example.simple_restapi.entity.User;
import com.example.simple_restapi.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User user1 = userDaoService.createUSer(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userDaoService.getUsers());
    }
}
