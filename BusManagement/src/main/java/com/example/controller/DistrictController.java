package com.example.controller;

import java.util.*;

import com.example.entites.*;
import com.example.services.DistrictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DistrictController {
    

    @Autowired 
    private DistrictService districtService;

     // Add District
     @PostMapping("/district" )
     public ResponseEntity<District> addDis(@RequestBody District district){
 
         try {
 
            District add = districtService.addDistrict(district);
             return ResponseEntity.status(HttpStatus.CREATED).body(add);
         } catch (Exception e) {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }

      // Get District Details
      @GetMapping("/district" )
      public ResponseEntity<List<District>> getDis(){
  
          try {

            List<District> list = districtService.getDistrict();

            if(list.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

              System.out.println(list);
              return ResponseEntity.status(HttpStatus.OK).body(list);
          } catch (Exception e) {
              e.printStackTrace();
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
          }
      }

      //Get District By Id
      @GetMapping("/district/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable("id") Long id){

        try {

            District addDistrict = districtService.getDistrictById(id);
            return ResponseEntity.status(HttpStatus.OK).body(addDistrict); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //Update District By Id
    @PutMapping("/district/{id}")
    public ResponseEntity<District> updateDistrictById(@RequestBody District district,@PathVariable("id") Long id){

        try {

            District addDistrict = districtService.updateDistrictById(district,id);
            return ResponseEntity.status(HttpStatus.OK).body(addDistrict); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete District By Id
    @DeleteMapping("/district/{id}")
    public ResponseEntity<District> deleteDistrictById(@PathVariable("id") Long id){

        try {

            District addDistrict = districtService.deleteDistrictById(id);
            return ResponseEntity.status(HttpStatus.OK).body(addDistrict); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
