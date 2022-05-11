package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.entites.Employee;
import com.example.response.ApiResponse;
import com.example.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

   

    // Add Employee
    @PostMapping("/addEmployee" )
    public ResponseEntity<ApiResponse> addEmp(@Valid @RequestBody final Employee emp){

      
            
            
            Employee add = employeeService.addEmp(emp);

            if (add != null) {
                
                return new ResponseEntity<ApiResponse>(new ApiResponse("Employee data added successfully",true), HttpStatus.CREATED);
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            
       
    }

    // Get All Employee
    @GetMapping("/getEmployee" )
    public ResponseEntity<List<Employee>> getEmp(){

            List<Employee> add = employeeService.getEmp();

  
                return new ResponseEntity<>(add, HttpStatus.OK);
           
            
        
    }

    // Get Employee By
    @GetMapping("/getEmployee/{id}" )
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long id){

      
            Employee emp = employeeService.getEmpById(id);
          
            return new ResponseEntity<Employee>(emp, HttpStatus.OK);

       
    }

    // update Employee By id
    @PutMapping("/updateEmployee/{id}" )
    public ResponseEntity<Employee> updateEmpById(@PathVariable("id") Long id,@RequestBody Employee emp){

        try {
            Employee emp1 = employeeService.updateEmpById(emp,id);
            
            if(emp1 == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (final Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete Employee By Id
    @DeleteMapping("/deleteEmployee/{id}" )
    public ResponseEntity<ApiResponse> deleteEmpById(@PathVariable("id") Long id){

       
             employeeService.deleteEmpById(id);
        
                return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted data successfully",true), HttpStatus.OK);
          
    }
}
