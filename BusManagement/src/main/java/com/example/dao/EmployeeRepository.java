package com.example.dao;

import com.example.entites.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    // @Query("select e from Employee e.empId = :id")
    @Query("SELECT e FROM Employee e WHERE e.empId = :id")
    public Employee findEmpById(@Param("id") Long id);

    
    @Query("delete from Employee e where e.empId= :id")
    public Employee deleteEmpById(@Param("id") Long id);

}
