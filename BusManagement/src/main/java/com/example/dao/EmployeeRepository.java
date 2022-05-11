package com.example.dao;

import com.example.entites.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    // @Query("select e from Employee e.empId = :id")
    // @Query("SELECT e.userName FROM Employee e WHERE e.empId = :id")
    // public String findUserNameById(@Param("id") Long id);

    
    @Query("select e.userName from Employee e where e.userName= :email")
    public String findUserName(@Param("email") String userName);

}
