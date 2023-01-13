package com.proj.api.user;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.websocket.Session;

@Repository
public class UserDaoImpl {
    @Autowired
    private EntityManager em;

    public User save(User user) {
        Session session = em.unwrap(Session.class);
        ((EntityManager) session).persist(user);
        return user;
    }
}
