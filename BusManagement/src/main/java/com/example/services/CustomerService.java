package com.example.services;


import java.util.List;

import com.example.dao.CustomerRepository;
import com.example.entites.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired 
    private CustomerRepository customerRepository;


    // Add Customer service
    public Customer addCustomer(Customer customer){

        Customer add = null;
        try{

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
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return list;
    }

    // Get Customer By id
    public Customer getCustomerById(Long id){

        Customer customer=null;
        try{

             customer = customerRepository.findCustomerById(id);      
                
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            
        }
        return customer;
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

        customerRepository.save(add);   
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
           
       }
       
        return add;
    }

     // Delete Customer By id
     public void deleteCustomerById(Long id){
        
        try{
          
            customerRepository.deleteById(id);      
       }
       catch(Exception e){
           e.printStackTrace();
          
       }
       
    }
}
