package com.proj.api.user;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository {

    User findByUsername(String username);

    User findByEmail(String email);
}
