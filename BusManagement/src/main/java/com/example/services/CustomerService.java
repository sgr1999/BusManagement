package com.example.services;


import java.util.List;

import com.example.dao.CustomerRepository;
import com.example.entites.Customer;

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
        try{

            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
             add = customerRepository.save(customer);  
             return add;    
        }
        catch(DataIntegrityViolationException e1){
            System.out.println("UserName Already exist in database");

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All Customer 
    public List<Customer> getAllCustomer(){

        List<Customer> list=null;
        try{

            list = customerRepository.findAll();    
            return list;   
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return null;
    }

    // Get Customer By id
    public Customer getCustomerById(Long id){

        Customer customer=null;
        try{

             customer = customerRepository.getById(id);      
                return customer;
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return null;
    }

    // Update Customer By Id
    public Customer UpdateCustomerById(Customer customer, Long id){

        Customer add=null;
        try{

             add = customerRepository.findCustomerById(id);    
        
        add.setFirstName(customer.getFirstName());
        add.setLastName(customer.getLastName());
        add.setUserName(customer.getUserName());
        add.setPassword(customer.getPassword());
        add.setGender(customer.getGender());
        add.setAge(customer.getAge());
        add.setMobileNumber(customer.getMobileNumber());

       add =  customerRepository.save(add);   
       return add;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
           
           return null;
       }
       
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
