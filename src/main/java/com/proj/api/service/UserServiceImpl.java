package com.proj.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.api.user.ApiResponse;
import com.proj.api.user.LoginDto;
import com.proj.api.user.SignUpDto;
import com.proj.api.user.User;
import com.proj.api.user.UserDao;
import com.proj.api.user.UserDaoImpl;



@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public ApiResponse signUp(SignUpDto signUpDto) {
        validateSignUp(signUpDto);
        User user = new User();
        //can use Bcrypt
        BeanUtils.copyProperties(signUpDto, user);
        userDaoImpl.save(user);
        return new ApiResponse(200, "success", user);
    }

    @Override
    public ApiResponse login(LoginDto loginDto) {
        User user = userDao.findByUsername(loginDto.getUsername());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", null) ;

    }

    private void validateSignUp(SignUpDto signUpDto) {
    }
}
