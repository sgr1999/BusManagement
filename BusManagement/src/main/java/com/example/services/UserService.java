package com.example.services;

import com.example.dao.UserRepository;
import com.example.entites.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public User addUser(User user){
        
        User save = userRepository.save(user);
        System.out.println(save);
        return user;
    }
}
