package com.proj.api.service;

import com.proj.api.user.ApiResponse;
import com.proj.api.user.LoginDto;
import com.proj.api.user.SignUpDto;

public interface UserService {

    ApiResponse signUp(SignUpDto signUpDto);

    ApiResponse login(LoginDto loginDto);
    
}
