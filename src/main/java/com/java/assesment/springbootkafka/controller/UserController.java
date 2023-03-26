package com.java.assesment.springbootkafka.controller;

import com.java.assesment.springbootkafka.dto.User;
import com.java.assesment.springbootkafka.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/kafka")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/users/{name}")
    public User getAllUsers(@PathVariable String name) {
        return userService.getUserByName(name);
    }

}
