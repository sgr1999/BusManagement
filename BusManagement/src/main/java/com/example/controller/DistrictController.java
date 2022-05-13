package com.example.controller;

import java.util.*;
import javax.validation.Valid;

import com.example.Model.DistrictModel;
import com.example.entites.*;
import com.example.response.ApiResponse1;
import com.example.services.DistrictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    // Add District
    @PostMapping("/addDistrict")
    public ResponseEntity<ApiResponse1> addDis(@Valid @RequestBody District district) {

        District add = districtService.addDistrict(district);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("District all information added successfully!!"),
                HttpStatus.CREATED);

    }

    // Get District Details
    @GetMapping("/getDistrict")
    public ResponseEntity<List<DistrictModel>> getDis() {

        List<DistrictModel> list = districtService.getDistrict();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    // //Get District By Id
    @GetMapping("/getDistrict/{id}")
    public ResponseEntity<DistrictModel> getDistrictById(@PathVariable("id") Long id) {

        DistrictModel addDistrict = districtService.getDistrictById(id);
        return ResponseEntity.status(HttpStatus.OK).body(addDistrict);

    }

    // Update District By Id
    @PutMapping("/updateDistrict/{id}")
    public ResponseEntity<ApiResponse1> updateDistrictById(@Valid @RequestBody District district,
            @PathVariable("id") Long id) {

        districtService.updateDistrictById(district, id);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("district data updated successfully!!"),
                HttpStatus.OK);

    }

    // Delete District By Id
    @DeleteMapping("/deleteDistrict/{id}")
    public ResponseEntity<ApiResponse1> deleteDistrictById(@PathVariable("id") Long id) {

        districtService.deleteDistrictById(id);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("district deleted successfully!!"),HttpStatus.OK);

    }
}
