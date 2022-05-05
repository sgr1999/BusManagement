package com.example.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.Model.BusTypeModel1;
import com.example.entites.BusType;
import com.example.services.BusTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/busType")
public class BusTypeController {
    
    @Autowired
    private BusTypeService busTypeService;

    //Add BusType Details
    @PostMapping("/addBusType")
    public ResponseEntity<BusType> addBusType(@Valid @RequestBody BusType busType){

        try {

            BusType addBusType = busTypeService.addBusType(busType);

            if (addBusType!=null) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            }
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
           
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusType Details
    @GetMapping("/getBusType" )
    public ResponseEntity<List<BusTypeModel1>> getBusType(){

        List<BusTypeModel1> list =null;
        try {

            list= busTypeService.getBusType();
           if(list.size()<=0){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }

            System.out.println(list);
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Get BusType By Id
    @GetMapping("/getBusType/{id}")
  public ResponseEntity<Map<String,Object>> getBusTypeById(@PathVariable("id") Long id){
    Map<String,Object> list =null;
      try {

           list= busTypeService.getBusTypeById(id);

          if(list==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
          return ResponseEntity.status(HttpStatus.OK).body(list); 
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }


  //Update BusType By Id
  @PutMapping("/updateBusType/{id}")
  public ResponseEntity<BusType> updateBusTypeById(@RequestBody BusType busType,@PathVariable("id") Long id){

      try {

          BusType add = busTypeService.updateBusTypeById(busType,id);
          if(add==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
          return ResponseEntity.status(HttpStatus.OK).build(); 
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }

  // Delete BusType By Id
  @DeleteMapping("/deleteBusType/{id}")
  public ResponseEntity<BusType> deleteBusTypeById(@PathVariable("id") Long id){

      try {

          BusType add = busTypeService.deleteBusTypeById(id);
          if(add==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
          return ResponseEntity.status(HttpStatus.OK).build(); 
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
}
