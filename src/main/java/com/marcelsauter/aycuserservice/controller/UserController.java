package com.marcelsauter.aycuserservice.controller;

import com.marcelsauter.aycuserservice.model.UserEntity;
import com.marcelsauter.aycuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity saveUserData(@RequestBody UserEntity userData) {
        return this.userService.saveUserData(userData);
    }
}
