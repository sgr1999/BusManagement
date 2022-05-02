package com.example.controller;


import java.util.List;

import javax.persistence.Cache;
import javax.validation.Valid;

import com.example.entites.Customer;
import com.example.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
@RequestMapping("/customer")
public class CustomerController {
    

    @Autowired
    private CustomerService customerService;

    // Add Customer Details
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){

        try {

            Customer add = customerService.addCustomer(customer);
            
            if(add !=null){

                return ResponseEntity.status(HttpStatus.CREATED).body(add);
            }
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get Customer By Id
    @GetMapping("/getCustomer/{id}")
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
    @GetMapping("/getCustomer")
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
    @PutMapping("/updateCustomer/{id}")
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
  @DeleteMapping("/deleteCustomer/{id}")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){


      try {

        customerService.deleteCustomerById(id);
     
          return ResponseEntity.status(HttpStatus.OK).build();
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }

}
