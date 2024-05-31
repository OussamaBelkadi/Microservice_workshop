package com.example.simple_restapi.service;

import com.example.simple_restapi.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"os", LocalDate.now()));
        users.add(new User(2,"mm", LocalDate.now()));
        users.add(new User(3,"ac", LocalDate.now()));
    }

    public List<User> getUsers() {
        return users;
    }
    public User findUserById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public User createUSer(User user){
        users.add(user);
        return user;
    }
}
