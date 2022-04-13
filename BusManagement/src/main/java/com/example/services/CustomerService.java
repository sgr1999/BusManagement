package com.example.services;

import com.example.dao.CustomerRepository;
import com.example.entites.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
    
    @Autowired 
    private CustomerRepository customerRepository;


    // Add Customer service
    public Customer addCustomer(Customer customer){

        Customer save = customerRepository.save(customer);        
        return save;
    }
}
