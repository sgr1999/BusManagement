package com.example.services;

import com.example.dao.CustomerRepository;
import com.example.entites.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
    
    
    // Add Customer service
    public Customer addCustomer(Customer customer){

        
        return customer;
    }
}
