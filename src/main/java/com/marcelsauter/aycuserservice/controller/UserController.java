package com.marcelsauter.aycuserservice.controller;

import com.ayc.exceptionhandler.exception.EntityNotFoundException;
import com.ayc.exceptionhandler.exception.NotAuthorizedException;
import com.marcelsauter.aycuserservice.model.UserEntity;
import com.marcelsauter.aycuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public UserEntity getUserData() throws EntityNotFoundException {
        return this.userService.getUserData();
    }

    @GetMapping("/{username}")
    public UserEntity getUserDataByUsername(@PathVariable("username") String username) throws NotAuthorizedException, EntityNotFoundException {
        return this.userService.getUserDataByUsername(username);
    }

    @PostMapping
    public UserEntity saveUserData(@RequestBody UserEntity userData) {
        return this.userService.saveUserData(userData);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable("username") String username) throws NotAuthorizedException {
        this.userService.deleteUser(username);
    }
}
