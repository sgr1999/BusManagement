package com.example.services;

import java.util.List;

import com.example.dao.UserRepository;
import com.example.entites.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    // Add User Details
    public User addUser(User user){

        User add = null;
        try{

            user.setPassword(passwordEncoder.encode(user.getPassword()));

            System.out.println("------"+user.getPassword());
             add = userRepository.save(user);     
             return add;  
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return null;
    }

    // Get All User 
    public List<User> getAllUser(){

        List<User> list=null;
        try{

            list = userRepository.findAll();       
            return list;
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
            return null;
        }
    }

    // Get User By id
    public User getUserById(Long id){

        User user=null;
        try{

             user = userRepository.findUserById(id);     
             
             return user;
                
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return null;
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

        User save = userRepository.save(add);   
        return save;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
           
       }
       
        return null;
    }

     // Delete User By id
     public User deleteUserById(Long id){

        User list = null;
        try{
           list = userRepository.findUserById(id);
            userRepository.deleteById(id);    
            
            return list;
       }
       catch(Exception e){
           e.printStackTrace();
          
       }

       return null;
    }
    
}
