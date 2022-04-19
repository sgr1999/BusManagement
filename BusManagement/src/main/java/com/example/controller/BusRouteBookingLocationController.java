package com.example.controller;

import java.util.List;

import com.example.entites.BusRouteBookingLocation;
import com.example.services.BusRouteBookingLocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusRouteBookingLocationController {
    
    @Autowired
    private BusRouteBookingLocationService busRouteBookingLocationService;

    //Add BusRouteBookingLocation Details
    @PostMapping("/busRouteBookingLocation")
    public ResponseEntity<BusRouteBookingLocation> addBusDepo(@RequestBody BusRouteBookingLocation bus){

        try {

            BusRouteBookingLocation addBusDepo = busRouteBookingLocationService.addBusLocation(bus);
            System.out.println(addBusDepo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusDepo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusRouteBookingLocation Details
    @GetMapping("/busRouteBookingLocation" )
    public ResponseEntity<List<BusRouteBookingLocation>> getBusLocation(){

       List<BusRouteBookingLocation> list =null;
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
    @GetMapping("/busRouteBookingLocation/{id}")
  public ResponseEntity<BusRouteBookingLocation> getBusLocationById(@PathVariable("id") Long id){
   BusRouteBookingLocation list =null;
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
  @PutMapping("/busRouteBookingLocation/{id}")
  public ResponseEntity<BusRouteBookingLocation> updateBusDepoById(@RequestBody BusRouteBookingLocation bus,@PathVariable("id") Long id){

      try {

          BusRouteBookingLocation add = busRouteBookingLocationService.updateBusLocationById(bus,id);
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

  // Delete BusRouteBookingLocation By Id
  @DeleteMapping("/busRouteBookingLocation/{id}")
  public ResponseEntity<BusRouteBookingLocation> deleteBusDepoById(@PathVariable("id") Long id){

      try {

          BusRouteBookingLocation add = busRouteBookingLocationService.deleteBusLocationById(id);
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
