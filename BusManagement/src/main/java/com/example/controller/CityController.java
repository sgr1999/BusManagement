package com.example.controller;

import com.example.Model.CityModel;
import com.example.entites.City;
import com.example.response.ApiResponse1;
import com.example.services.CityService;

import java.util.*;

import javax.validation.Valid;

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

    // Add City Details
    @PostMapping("/addCity")
    public ResponseEntity<ApiResponse1> addCity(@Valid @RequestBody City city) {

        City addCity = cityService.addCity(city);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("City information added successfully!!"),
                HttpStatus.OK);

    }

    // Get City All
    @GetMapping("/getCity")
    public ResponseEntity<List<CityModel>> getCity() {

        List<CityModel> addCity = cityService.getCity();

        return ResponseEntity.status(HttpStatus.OK).body(addCity);

    }

    // Get City By Id
    @GetMapping("/getCity/{id}")
    public ResponseEntity<CityModel> getCityById(@PathVariable("id") Long id) {

        CityModel addCity = cityService.getCityById(id);

        return ResponseEntity.status(HttpStatus.OK).body(addCity);

    }

    @PutMapping("/updateCity/{id}")
    public ResponseEntity<ApiResponse1> updateCityById(@Valid @RequestBody City city, @PathVariable("id") Long id) {

        cityService.updateCityById(city, id);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("City information updated successfully!"),
                HttpStatus.OK);

    }

    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity<ApiResponse1> deleteCityById(@PathVariable("id") Long id) {

        cityService.deleteCityById(id);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("City information deleted successfully!"), HttpStatus.OK);

    }

}
