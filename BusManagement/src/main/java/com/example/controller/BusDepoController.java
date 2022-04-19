package com.example.controller;

import java.util.List;

import com.example.entites.BusDepo;
import com.example.services.BusDepoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BusDepoController {
    
    @Autowired
    private BusDepoService busDepoService;

    //Add BusDepo Details
    @PostMapping("/busDepo")
    public ResponseEntity<BusDepo> addBusDepo(@RequestBody BusDepo busDepo){

        try {

            BusDepo addBusDepo = busDepoService.addBusDepo(busDepo);
            System.out.println(addBusDepo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusDepo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusDepo Details
    @GetMapping("/busDepo" )
    public ResponseEntity<List<BusDepo>> getBusDepo(){

       List<BusDepo> list =null;
        try {

            list= busDepoService.getBusDepo();
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

    //Get BusDepo By Id
    @GetMapping("/busDepo/{id}")
  public ResponseEntity<BusDepo> getBusDepoById(@PathVariable("id") Long id){
   BusDepo list =null;
      try {

           list= busDepoService.getBusDepoById(id);

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


  //Update BusDepo By Id
  @PutMapping("/busDepo/{id}")
  public ResponseEntity<BusDepo> updateBusDepoById(@RequestBody BusDepo busDepo,@PathVariable("id") Long id){

      try {

          BusDepo add = busDepoService.updateBusDepoById(busDepo,id);
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

  // Delete BusDepo By Id
  @DeleteMapping("/busDepo/{id}")
  public ResponseEntity<BusDepo> deleteBusDepoById(@PathVariable("id") Long id){

      try {

          BusDepo add = busDepoService.deleteBusDepoById(id);
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
