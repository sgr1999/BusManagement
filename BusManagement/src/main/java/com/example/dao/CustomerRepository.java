package com.example.dao;

import com.example.entites.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
    @Query("select c from Customer c where c.customerId= :id")
    public Customer findCustomerById(@Param("id") Long id);

    @Query("select c.userName from Customer c where c.userName= :id")
    public String findUserName(@Param("id") String userName);
}
