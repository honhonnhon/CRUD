package com.proj.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.api.user.DeleteDto;
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
    public ResponseEntity<String> signUp(SignUpDto signUpDto) {
        try{
               validateSignUp(signUpDto);
               User user = new User();

             BeanUtils.copyProperties(signUpDto, user);
             userDaoImpl.save(user);
            return new ResponseEntity<String>("Sign up success",HttpStatus.OK);
       } catch(Exception e){
           return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    }
    @Override
    public ResponseEntity<String> login(LoginDto loginDto) {
        User user = userDao.findByUsername(loginDto.getUsername());
        if(user == null) {
            return new ResponseEntity<String>("Login failed wrong username.",HttpStatus.NOT_FOUND);

        }
        if(!user.getPassword().equals(loginDto.getPassword())){
            return new ResponseEntity<String>("Login failed wrong password.",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Login success",HttpStatus.OK);

    }
    private void validateSignUp(SignUpDto signUpDto) throws Exception {
        if(signUpDto.getUsername() == null) {
            throw new Exception("user required.");
        }
        if(signUpDto.getPassword() == null) {
            throw new Exception("password required.");
        }
    }
    @Override
    public ResponseEntity<String> Delete(DeleteDto deletedto) {
        User user = userDao.findByUsername(deletedto.getUsername());
        if(user == null) {
            return new ResponseEntity<String>("Delete failed wrong username.",HttpStatus.NOT_FOUND);

        }
        if(!user.getPassword().equals(deletedto.getPassword())){
            return new ResponseEntity<String>("Delete failed wrong password.",HttpStatus.NOT_FOUND);
        }else{
            userDaoImpl.delete(user);
        }
        return new ResponseEntity<String>("Delete success",HttpStatus.OK);
    }
}