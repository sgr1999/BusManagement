package com.example.controller;

import java.util.List;

import com.example.Model.BusDepoRouteModel;
import com.example.entites.BusDepoRoute;
import com.example.services.BusDepoRouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/busDepoRoute")
public class BusDepoRouteController {
    
    @Autowired
    private BusDepoRouteService busDepoRouteService;

    //Add BusDepoRoute Details
    @PostMapping("/addBusDepoRoute")
    public ResponseEntity<BusDepoRoute> addBusDepoRoute(@RequestBody BusDepoRoute busDepoRoute){

        try {

            BusDepoRoute addBusDepo = busDepoRouteService.addBusDepoRoute(busDepoRoute);
            System.out.println(addBusDepo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusDepo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusDepoRoute Details
    @GetMapping("/getBusDepoRoute" )
    public ResponseEntity<List<BusDepoRouteModel>> getBusDepoRoute(){

       List<BusDepoRouteModel> list =null;
        try {

            list= busDepoRouteService.getBusDepoRoute();
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

    //Get BusDepoRoute By Id
    @GetMapping("/getBusDepoRoute/{id}")
  public ResponseEntity<BusDepoRoute> getBusDepoById(@PathVariable("id") Long id){
   BusDepoRoute list =null;
      try {

           list= busDepoRouteService.getBusDepoRouteById(id);

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


  //Update BusDepoRoute By Id
  @PutMapping("/updateBusDepoRoute/{id}")
  public ResponseEntity<BusDepoRoute> updateBusDepoRouteById(@RequestBody BusDepoRoute busDepoRoute,@PathVariable("id") Long id){

      try {

          BusDepoRoute add = busDepoRouteService.updateBusDepoRouteById(busDepoRoute,id);
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

  // Delete BusDepoRoute By Id
  @DeleteMapping("/deleteBusDepoRoute/{id}")
  public ResponseEntity<BusDepoRoute> deleteBusDepoRouteById(@PathVariable("id") Long id){

      try {

          BusDepoRoute add = busDepoRouteService.deleteBusDepoRouteById(id);
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
