package com.example.controller;

import java.util.List;

import com.example.dao.BusBookingRepository;
import com.example.entites.BusBooking;
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
public class UserController {

	@Autowired
	private UserService userService;
    
    // Add User Details
    @PostMapping("/user")
    public ResponseEntity<User> addCustomer(@RequestBody User user){

        try {

            User add = userService.addUser(user);
       
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get User By Id
    @GetMapping("/user/{id}")
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
    @GetMapping("/user")
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
    @PutMapping("/user/{id}")
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
  @DeleteMapping("/user/{id}")
  public ResponseEntity deleteCustomer(@PathVariable("id") Long id){

      try {

          userService.deleteUserById(id);
     
          return ResponseEntity.status(HttpStatus.OK).build();
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }

    

    

}
