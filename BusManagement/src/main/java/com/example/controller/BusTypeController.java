package com.example.controller;

import java.util.List;

import com.example.entites.BusType;
import com.example.services.BusTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusTypeController {
    
    @Autowired
    private BusTypeService busTypeService;

    //Add BusType Details
    @PostMapping("/busType")
    public ResponseEntity<BusType> addBusType(@RequestBody BusType busType){

        try {

            BusType addBusType = busTypeService.addBusType(busType);
            System.out.println(addBusType);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusType);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusType Details
    @GetMapping("/busType" )
    public ResponseEntity<List<BusType>> getBusType(){

       List<BusType> list =null;
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
    @GetMapping("/busType/{id}")
  public ResponseEntity<BusType> getBusTypeById(@PathVariable("id") Long id){
   BusType list =null;
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
  @PutMapping("/busType/{id}")
  public ResponseEntity<BusType> updateBusTypeById(@RequestBody BusType busType,@PathVariable("id") Long id){

      try {

          BusType add = busTypeService.updateBusTypeById(busType,id);
          if(add==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
          return ResponseEntity.status(HttpStatus.OK).body(add); 
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }

  // Delete BusType By Id
  @DeleteMapping("/busType/{id}")
  public ResponseEntity<BusType> deleteBusTypeById(@PathVariable("id") Long id){

      try {

          BusType add = busTypeService.deleteBusTypeById(id);
          if(add==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
          return ResponseEntity.status(HttpStatus.OK).body(add); 
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
}
