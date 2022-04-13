package com.example.controller;

import com.example.entites.Customer;
import com.example.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CustomerController {
    

    @Autowired
    private CustomerService customerService;

    // Add Customer Details
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        try {

            Customer add = customerService.addCustomer(customer);
           
       
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
