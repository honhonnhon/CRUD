package com.proj.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.api.service.UserService;
import com.proj.api.user.ApiResponse;
import com.proj.api.user.LoginDto;
import com.proj.api.user.SignUpDto;

@RestController
@RequestMapping("/users")
public class usercontroller {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}
