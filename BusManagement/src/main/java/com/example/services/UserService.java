package com.example.services;

import com.example.entites.User;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    
    public User addUser(User user){
        
        System.out.println(user);
        return user;
    }
}
