package com.example.services;


import java.util.List;

import com.example.dao.CustomerRepository;
import com.example.entites.Customer;
import com.example.exception.DataAlreadyPresentExceptionHandling;
import com.example.exception.DataNotMatchException;
import com.example.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired 
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    // Add Customer service
    public Customer addCustomer(Customer customer){

        Customer add = null;

            customer.setPassword(passwordEncoder.encode(customer.getPassword()));

            String c= customerRepository.findUserName(customer.getUserName());

       if (c !=null) {
           throw new DataAlreadyPresentExceptionHandling("Customer", "userName", customer.getUserName());
       }
             add = customerRepository.save(customer);  
             return add;    
      
    }

    // Get All Customer 
    public List<Customer> getAllCustomer(){

        List<Customer> list=null;
       

            list = customerRepository.findAll();    

            if (list.size()<=0) {
                throw new ResourceNotFoundException();
            }
            return list;   
        
    }

    // Get Customer By id
    public Customer getCustomerById(Long id){

        Customer customer=null;

          customer= customerRepository.findById(id)
             .orElseThrow(()-> new ResourceNotFoundException("Customer","id",id));      
                return customer;
      
    }

    // Update Customer By Id
    public Customer UpdateCustomerById(Customer customer, Long id){

        Customer add = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","id",id));    
        
        if (customer.getUserName()!=add.getUserName()) {
            throw new DataNotMatchException("Customer", "id", id);
        }
        add.setFirstName(customer.getFirstName());
        add.setLastName(customer.getLastName());
        add.setUserName(add.getUserName());
        add.setPassword(customer.getPassword());
        add.setGender(customer.getGender());
        add.setAge(customer.getAge());
        add.setMobileNumber(customer.getMobileNumber());

       add =  customerRepository.save(add);   
       return add;
    }

     // Delete Customer By id
     public Customer deleteCustomerById(Long id){
        
        try{
          Customer list = customerRepository.getById(id);
            customerRepository.deleteById(id);    
            return list;
       }
       catch(Exception e){
           e.printStackTrace();
          return null;
       }
       
    }
}
