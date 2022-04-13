package com.example.controller;

import com.example.entites.Employee;
import com.example.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

   

    // Add Employee
    @PostMapping("/addEmp" )
    public ResponseEntity<Employee> addEmp(@RequestBody final Employee emp){

        try {

            final Employee add = employeeService.addEmp(emp);
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (final Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

     
    
}
