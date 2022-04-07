package com.example.controller;

import com.example.dao.BusBookingRepository;
import com.example.dao.CustomerRepository;
import com.example.entites.BusBooking;
import com.example.entites.Customer;
import com.example.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private BusBookingRepository busBookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    // busBooking 
    @PostMapping("/busBooking")
    public ResponseEntity<BusBooking> addBooking(@RequestBody BusBooking busBooking) {

        BusBooking b = null;

        try {

            BusBooking save = busBookingRepository.save(b);
            System.out.println(save);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // Add Customer Details
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        try {

            Customer add = customerService.addCustomer(customer);
            Customer save = customerRepository.save(add);
        System.out.println(save);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
