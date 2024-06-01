package com.example.simple_restapi.controller;

import com.example.simple_restapi.entity.User;
import com.example.simple_restapi.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class HelloWordController {
    private final UserDaoService userDaoService;
    private MessageSource messageSource;


    public HelloWordController(UserDaoService userDaoService, MessageSource messageSource) {
        this.userDaoService = userDaoService;
        this.messageSource = messageSource;
    }

    // /hello-world
    @RequestMapping(method = RequestMethod.GET, path = "/hello-word")
    public String helloWord(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default message", locale);
    }

    @PostMapping(path = "users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User user1 = userDaoService.createUSer(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping(path = "users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userDaoService.getUsers());
    }
}
