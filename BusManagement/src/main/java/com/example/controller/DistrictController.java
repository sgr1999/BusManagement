package com.example.controller;

import java.util.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.example.Model.DistrictModel;
import com.example.entites.*;
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
     @PostMapping("/addDistrict" )
     public ResponseEntity<District> addDis(@Valid @RequestBody Map<String,Object> mpDistrict){
 
         try {
 
            District add = districtService.addDistrict(mpDistrict);

            if (add != null) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
         } catch (Exception e) {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }

      // Get District Details
      @GetMapping("/getDistrict" )
      public ResponseEntity<List<DistrictModel>> getDis(){
  
          try {

            List<DistrictModel> list = districtService.getDistrict();

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
      @GetMapping("/getDistrict/{id}")
    public ResponseEntity<DistrictModel> getDistrictById(@PathVariable("id") Long id){

        try {

            DistrictModel addDistrict = districtService.getDistrictById(id);

            if(addDistrict !=null){
                return ResponseEntity.status(HttpStatus.OK).body(addDistrict); 
            }
            else{
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //Update District By Id
    @PutMapping("/updateDistrict/{id}")
    public ResponseEntity<District> updateDistrictById(@RequestBody District district,@PathVariable("id") Long id){

        try {

            District addDistrict = districtService.updateDistrictById(district,id);

            if (addDistrict != null) {
                return ResponseEntity.status(HttpStatus.OK).build(); 
            }
            else{
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete District By Id
    @DeleteMapping("/deleteDistrict/{id}")
    public ResponseEntity<District> deleteDistrictById(@PathVariable("id") Long id){

        try {
            District add = districtService.deleteDistrictById(id);
          //  System.out.println("controller ---------"+add);
            if (add != null) {
                
                return ResponseEntity.status(HttpStatus.OK).build();   
            }else{

                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
