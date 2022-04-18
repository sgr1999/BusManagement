package com.example.controller;


import java.util.List;

import com.example.entites.Customer;
import com.example.services.CustomerService;


import org.hibernate.type.ListType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CustomerController {
    

    @Autowired
    private CustomerService customerService;

    // Add Customer Details
    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        try {

            Customer add = customerService.addCustomer(customer);
       
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get Customer By Id
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){

        try {

            Customer add = customerService.getCustomerById(id);
       
            return ResponseEntity.status(HttpStatus.OK).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get All Customer Details
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomer(){

        try {

            List<Customer> add = customerService.getAllCustomer();
       
            return ResponseEntity.status(HttpStatus.OK).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update Customer By Id
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> UpdateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){

        try {

            Customer add = customerService.UpdateCustomerById(customer, id);
       
            return ResponseEntity.status(HttpStatus.OK).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

  // Delete Customer By id
  @DeleteMapping("/customer/{id}")
  public ResponseEntity deleteCustomer(@PathVariable("id") Long id){

      try {

          customerService.deleteCustomerById(id);
     
          return ResponseEntity.status(HttpStatus.OK).build();
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }

}
