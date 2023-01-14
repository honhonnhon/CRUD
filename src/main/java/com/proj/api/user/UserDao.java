package com.proj.api.user;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
@Service
public interface UserDao extends JpaRepository<User,String> {
    
    User findByUsername(String username);

    User findByEmail(String email);
}
