package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.entites.Employee;
import com.example.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

   

    // Add Employee
    @PostMapping("/employee" )
    public ResponseEntity<Employee> addEmp(@RequestBody final Employee emp){

        try {
            
            
            Employee add = employeeService.addEmp(emp);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (final Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get All Employee
    @GetMapping("/employee" )
    public ResponseEntity<List<Employee>> getEmp(){

        try {
            
            
            List<Employee> add = employeeService.getEmp();
            
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (final Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get Employee By
    @GetMapping("/employee/{id}" )
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long id){

        try {
            Employee emp = employeeService.getEmpById(id);
            
            if(emp == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            // return ResponseEntity.status(HttpStatus.CREATED).body(emp);

            return ResponseEntity.of(Optional.of(emp));
        } catch (final Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get Employee By
    @PutMapping("/employee/{id}" )
    public ResponseEntity<Employee> updateEmpById(@PathVariable("id") Long id,@RequestBody Employee emp){

        try {
            Employee emp1 = employeeService.updateEmpById(emp,id);
            
            if(emp1 == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            // return ResponseEntity.status(HttpStatus.CREATED).body(emp);

            return ResponseEntity.of(Optional.of(emp1));
        } catch (final Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete Employee By Id
    @DeleteMapping("/employee/{id}" )
    public ResponseEntity deleteEmpById(@PathVariable("id") Long id){

        try {
             employeeService.deleteEmpById(id);
            
            // if(emp1 == null){
            //     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            // }
            return ResponseEntity.status(HttpStatus.OK).build();

            // return ResponseEntity.of(Optional.of(emp1));
        } catch (final Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
