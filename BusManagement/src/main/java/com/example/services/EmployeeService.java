package com.example.services;

import com.example.dao.EmployeeRepository;
import com.example.entites.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmp(Employee emp){

        Employee save = employeeRepository.save(emp);
        System.out.println(save);
        return emp;
    }
}
