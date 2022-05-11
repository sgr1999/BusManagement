package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.entites.Employee;
import com.example.response.ApiResponse;
import com.example.response.ApiResponse1;
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

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Add Employee
    @PostMapping("/addEmployee")
    public ResponseEntity<ApiResponse> addEmp(@Valid @RequestBody final Employee emp) {

        Employee add = employeeService.addEmp(emp);

        if (add != null) {

            return new ResponseEntity<ApiResponse>(new ApiResponse("Employee data added successfully"),
                    HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // Get All Employee
    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getEmp() {

        List<Employee> add = employeeService.getEmp();

        return new ResponseEntity<>(add, HttpStatus.OK);

    }

    // Get Employee By
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long id) {

        Employee emp = employeeService.getEmpById(id);

        return new ResponseEntity<Employee>(emp, HttpStatus.OK);

    }

    // update Employee By id
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<ApiResponse1> updateEmpById(@Valid @PathVariable("id") Long id, @RequestBody Employee emp) {

        Employee emp1 = employeeService.updateEmpById(emp, id);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("Employee updated successfully"), HttpStatus.OK);
    }

    // Delete Employee By Id
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<ApiResponse> deleteEmpById(@PathVariable("id") Long id) {

        employeeService.deleteEmpById(id);

        return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted data successfully", true), HttpStatus.OK);

    }
}
