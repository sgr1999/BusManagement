package com.example.controller;

import com.example.Model.CityModel;
import com.example.entites.City;
import com.example.services.CityService;

import java.util.*;

import javax.validation.Valid;

import org.hibernate.metamodel.model.domain.spi.MapPersistentAttribute;
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

@Controller
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityService cityService;


    //Add City Details
    @PostMapping("/addCity")
    public ResponseEntity<City> addCity(@Valid @RequestBody City city){

        try {

            City addCity = cityService.addCity(city);

            if(addCity !=null){
                return ResponseEntity.status(HttpStatus.OK).build(); 
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    // Get City All
    @GetMapping("/getCity")
    public ResponseEntity<List<CityModel>> getCity(){

        try {

            List<CityModel> addCity = cityService.getCity();

            if (addCity.size()<=0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
            }
            return ResponseEntity.status(HttpStatus.OK).body(addCity); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getCity/{id}")
    public ResponseEntity<CityModel> getCityById(@PathVariable("id") Long id){

        try {

            CityModel addCity = cityService.getCityById(id);

            if (addCity !=null) {
                
                return ResponseEntity.status(HttpStatus.OK).body(addCity); 
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
           
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/updateCity/{id}")
    public ResponseEntity<City> updateCityById(@RequestBody City city,@PathVariable("id") Long id){

        try {

            City addCity = cityService.updateCityById(city,id);
            if (addCity !=null) {
                
                return ResponseEntity.status(HttpStatus.OK).build(); 
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity<City> deleteCityById(@PathVariable("id") Long id){

        try {

            City addCity = cityService.deleteCityById(id);

            if (addCity !=null) {
                
                return ResponseEntity.status(HttpStatus.OK).build(); 
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
