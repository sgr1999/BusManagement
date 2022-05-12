package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.entites.Customer;
import com.example.response.ApiResponse;
import com.example.response.ApiResponse1;
import com.example.services.CustomerService;

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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Add Customer Details
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {

        

            customerService.addCustomer(customer);

                return ResponseEntity.status(HttpStatus.CREATED).build();
      
    }

    // Get Customer By Id
    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {

            Customer add = customerService.getCustomerById(id);
 
            return ResponseEntity.status(HttpStatus.OK).body(add);
       
    }

    // Get All Customer Details
    @GetMapping("/getCustomer")
    public ResponseEntity<List<Customer>> getCustomer() {

            List<Customer> add = customerService.getAllCustomer();

            return ResponseEntity.status(HttpStatus.OK).body(add);
      
    }

    // Update Customer By Id
    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<ApiResponse1> UpdateCustomer(@Valid @RequestBody Customer customer, @PathVariable("id") Long id) {

             customerService.UpdateCustomerById(customer, id);
           
            return new ResponseEntity<ApiResponse1>(new ApiResponse1("Customer updated successfully"),HttpStatus.OK);
    }

    // Delete Customer By id
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<ApiResponse1> deleteCustomer(@PathVariable("id") Long id) {

       customerService.deleteCustomerById(id);
       return new ResponseEntity<ApiResponse1>(new ApiResponse1("employee data deleted successfully"),HttpStatus.OK);
    }
}
