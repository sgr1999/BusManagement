package com.example.services;

import java.util.List;

import com.example.dao.UserRepository;
import com.example.entites.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    // Add User Details
    public User addUser(User user){

        User add = null;
        try{

             add = userRepository.save(user);       
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return add;
    }

    // Get All User 
    public List<User> getAllUser(){

        List<User> list=null;
        try{

            list = userRepository.findAll();       
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return list;
    }

    // Get User By id
    public User getUserById(Long id){

        User user=null;
        try{

             user = userRepository.findUserById(id);      
                
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return user;
    }

    // Update User By Id
    public User UpdateUserById(User user, Long id){

        User add=null;
        try{

             add = userRepository.findUserById(id);    
        
        add.setFirstName(user.getFirstName());
        add.setLastName(user.getLastName());
        add.setUserName(user.getUserName());
        add.setPassword(user.getPassword());
        add.setStatus(user.getStatus());
        add.setMobileNo(user.getMobileNo());

        userRepository.save(add);   
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
           
       }
       
        return add;
    }

     // Delete User By id
     public User deleteUserById(Long id){

        User list = null;
        try{
           list = userRepository.findUserById(id);
            userRepository.deleteById(id);      
       }
       catch(Exception e){
           e.printStackTrace();
          
       }

       return list;
    }
    
}
