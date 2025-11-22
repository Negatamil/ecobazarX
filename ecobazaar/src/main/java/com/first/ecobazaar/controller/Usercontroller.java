package com.first.ecobazaar.controller;

import com.first.ecobazaar.entity.UserEntity;
import com.first.ecobazaar.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller {
    @Autowired
    private UserSer userService;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return userService.registerUser(user);
    }

    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/login")
    public String login(@RequestBody UserEntity user) {
        return userService.authenticateUser(user.getEmail(), user.getPassword());
    }
}
