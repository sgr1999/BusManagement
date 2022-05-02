package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.entites.User;
import com.example.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
    
    // Add User Details
    @PostMapping("/addUser")
    public ResponseEntity<User> addCustomer(@Valid @RequestBody User user){

        try {

        
            User add = userService.addUser(user);

            if (add !=null) {
                
                return ResponseEntity.status(HttpStatus.CREATED).body(add);
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
       
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get User By Id
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getCustomerById(@PathVariable("id") Long id){

        try {

            User add = userService.getUserById(id);
       
            return ResponseEntity.status(HttpStatus.OK).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get All User Details
    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getCustomer(){

        try {

            List<User> add = userService.getAllUser();
       
            return ResponseEntity.status(HttpStatus.OK).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update User By Id
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> UpdateCustomer(@RequestBody User user, @PathVariable("id") Long id){

        try {

            User add = userService.UpdateUserById(user, id);
       
            return ResponseEntity.status(HttpStatus.OK).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

  // Delete User By id
  @DeleteMapping("/deleteUser/{id}")
  public ResponseEntity<User> deleteCustomer(@PathVariable("id") Long id){

    User list = null;
      try {

          list =userService.deleteUserById(id);
     
          return ResponseEntity.status(HttpStatus.OK).body(list);
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }

    

    

}
