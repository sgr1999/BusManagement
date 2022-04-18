package com.example.controller;

import com.example.entites.City;
import com.example.services.CityService;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CityController {
    
    @Autowired
    private CityService cityService;


    //Add City Details
    @PostMapping("/city")
    public ResponseEntity<City> addCity(@RequestBody City city){

        try {

            City addCity = cityService.addCity(city);
            return ResponseEntity.status(HttpStatus.OK).body(addCity); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @GetMapping("/city")
    public ResponseEntity<List<City>> getCity(){

        try {

            List<City> addCity = cityService.getCity();
            return ResponseEntity.status(HttpStatus.OK).body(addCity); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
