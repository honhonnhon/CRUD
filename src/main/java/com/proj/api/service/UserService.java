package com.proj.api.service;

import org.springframework.http.ResponseEntity;

import com.proj.api.user.ApiResponse;
import com.proj.api.user.LoginDto;
import com.proj.api.user.SignUpDto;

public interface UserService {

    ResponseEntity<String> signUp(SignUpDto signUpDto);

    ResponseEntity<String> login(LoginDto loginDto);
    
}
