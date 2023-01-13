package com.proj.api.user;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<String,User> {

    User findByUsername(String username);

    User findByEmail(String email);
}
