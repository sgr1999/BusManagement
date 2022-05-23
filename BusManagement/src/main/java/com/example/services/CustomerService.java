package com.example.services;


import java.util.List;

import com.example.Model.CustomerModel;
import com.example.dao.CustomerRepository;
import com.example.entites.Customer;
import com.example.exception.DataAlreadyPresentExceptionHandling;
import com.example.exception.DataNotMatchException;
import com.example.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
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
        
       
        if (!customer.getUserName().equals(add.getUserName())) {
            throw new DataNotMatchException("Customer", "id", id);
        }
        
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

     // Delete Customer By id
     public void deleteCustomerById(Long id){
        
   
          Customer list = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","id",id));
            customerRepository.delete(list);   
       
     
    }

    public CustomerModel cutomerToModel(Customer customer){

        CustomerModel model = new CustomerModel();

        model.setFirstName(customer.getFirstName());
        model.setLastName(customer.getLastName());
        model.setMobileNumber(customer.getMobileNumber());
        model.setPassword(customer.getPassword());
        model.setAge(customer.getAge());
        model.setGender(customer.getGender());
        model.setUserName(customer.getUserName());

        return model;
     }

     public Customer modelToCustomer(CustomerModel customer){

        Customer model = new Customer();

        model.setFirstName(customer.getFirstName());
        model.setLastName(customer.getLastName());
        model.setMobileNumber(customer.getMobileNumber());
        model.setPassword(customer.getPassword());
        model.setAge(customer.getAge());
        model.setGender(customer.getGender());
        model.setUserName(customer.getUserName());

        return model;
     }
}
