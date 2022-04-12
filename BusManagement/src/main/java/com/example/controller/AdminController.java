package com.example.controller;

import com.example.entites.City;
import com.example.entites.District;
import com.example.entites.Employee;
import com.example.entites.State;
import com.example.services.EmployeeService;
import com.example.services.StateDistrictCityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StateDistrictCityService stateDistrictCityService;

    // Add Employee
    @PostMapping("/addEmp" )
    public ResponseEntity<Employee> addEmp(@RequestBody Employee emp){

        try {

            Employee add = employeeService.addEmp(emp);
            return ResponseEntity.status(HttpStatus.CREATED).body(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

     // Add State
     @PostMapping("/addState" )
     public ResponseEntity<State> addState(@RequestBody State state){
 
         try {
 
            State add = stateDistrictCityService.addState(state);
             return ResponseEntity.status(HttpStatus.CREATED).body(add);
         } catch (Exception e) {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }

     // Add District
     @PostMapping("/addDistrict" )
     public ResponseEntity<District> addDis(@RequestBody District district){
 
         try {
 
            District add = stateDistrictCityService.addDistrict(district);
             return ResponseEntity.status(HttpStatus.CREATED).body(add);
         } catch (Exception e) {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }

      // Get District Details
      @GetMapping("/getDistrict" )
      public ResponseEntity<District> getDis(@RequestBody District district){
  
          try {
  
             District add = stateDistrictCityService.getDistrict(district);
             System.out.println(add);
              return ResponseEntity.status(HttpStatus.OK).body(add);
          } catch (Exception e) {
              e.printStackTrace();
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
          }
      }

       // Add City
       @PostMapping("/addCity" )
       public ResponseEntity<City> addCity(@RequestBody City city){
   
           try {
   
              City add =stateDistrictCityService.addCity(city);
               return ResponseEntity.status(HttpStatus.CREATED).body(add);
           } catch (Exception e) {
               e.printStackTrace();
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
           }
       }
  


}
