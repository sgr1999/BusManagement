package com.example.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.Model.BusRouteBookingLocationModel;
import com.example.entites.BusRouteBookingLocation;
import com.example.services.BusRouteBookingLocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/busRouteBookingLocation")
public class BusRouteBookingLocationController {
    
    @Autowired
    private BusRouteBookingLocationService busRouteBookingLocationService;

    //Add BusRouteBookingLocation Details
    @PostMapping("/addBusRouteBookingLocation")
    public ResponseEntity<BusRouteBookingLocation> addBusDepo(@Valid @RequestBody BusRouteBookingLocation bus){

        try {

            BusRouteBookingLocation addBusDepo = busRouteBookingLocationService.addBusLocation(bus);
            
            if (addBusDepo !=null) {
                
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusRouteBookingLocation Details
    @GetMapping("/getBusRouteBookingLocation" )
    public ResponseEntity<List<BusRouteBookingLocationModel>> getBusLocation(){

       List<BusRouteBookingLocationModel> list =null;
        try {

            list= busRouteBookingLocationService.getBuslocation();
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

    //Get BusRouteBookingLocation By Id
    @GetMapping("/getBusRouteBookingLocation/{id}")
  public ResponseEntity<Map<String,Object>> getBusLocationById(@PathVariable("id") Long id){
    Map<String,Object> list =null;
      try {

           list= busRouteBookingLocationService.getBusLocationById(id);

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


  //Update BusRouteBookingLocation By Id
  @PutMapping("/updateBusRouteBookingLocation/{id}")
  public ResponseEntity<BusRouteBookingLocation> updateBusDepoById(@RequestBody BusRouteBookingLocation bus,@PathVariable("id") Long id){

      try {

          BusRouteBookingLocation add = busRouteBookingLocationService.updateBusLocationById(bus,id);
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

  // Delete BusRouteBookingLocation By Id
  @DeleteMapping("/deleteBusRouteBookingLocation/{id}")
  public ResponseEntity<BusRouteBookingLocation> deleteBusDepoById(@PathVariable("id") Long id){

      try {

          BusRouteBookingLocation add = busRouteBookingLocationService.deleteBusLocationById(id);
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
