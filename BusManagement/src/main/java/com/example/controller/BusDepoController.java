package com.example.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.Model.BusDepoModel;
import com.example.entites.BusDepo;
import com.example.services.BusDepoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/busDepo")
public class BusDepoController {
    
    @Autowired
    private BusDepoService busDepoService;

    //Add BusDepo Details
    @PostMapping("/addBusDepo")
    public ResponseEntity<BusDepo> addBusDepo(@Valid @RequestBody BusDepo busDepo){

        try {

            BusDepo addBusDepo = busDepoService.addBusDepo(busDepo);

            if (addBusDepo !=null) {
                
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

    // Get BusDepo Details
    @GetMapping("/getBusDepo" )
    public ResponseEntity<List<BusDepoModel>> getBusDepo(){

        List<BusDepoModel> list =null;
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
    @GetMapping("/getBusDepo/{id}")
  public ResponseEntity<BusDepoModel> getBusDepoById(@PathVariable("id") Long id){
    BusDepoModel list =null;
      try {

           list= busDepoService.getBusDepoById(id);

          if(list!=null){
            return ResponseEntity.status(HttpStatus.OK).build(); 
         }
         else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }


  //Update BusDepo By Id
  @PutMapping("/updateBusDepo/{id}")
  public ResponseEntity<BusDepo> updateBusDepoById(@RequestBody BusDepo busDepo,@PathVariable("id") Long id){

      try {

          BusDepo add = busDepoService.updateBusDepoById(busDepo,id);
          if(add!=null){
              return ResponseEntity.status(HttpStatus.OK).build(); 
        }else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }

  // Delete BusDepo By Id
  @DeleteMapping("/deleteBusDepo/{id}")
  public ResponseEntity<BusDepo> deleteBusDepoById(@PathVariable("id") Long id){

      try {

          BusDepo add = busDepoService.deleteBusDepoById(id);
          if(add!=null){
              return ResponseEntity.status(HttpStatus.OK).build(); 
        }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
}
