package com.example.controller;

import java.util.List;
import java.util.Map;

import com.example.Model.BusBookingModel;
import com.example.entites.BusBooking;
import com.example.services.BusBookingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("busBooking")
public class BusBookingController {
    
    @Autowired
    private BusBookingServices busBookingServices;

    //Add BusBooking Details
    @PostMapping("/addBooking")
    public ResponseEntity<BusBooking> addBusBooking(@RequestBody Map<String, Object> mpBusBooking){
        try {

            BusBooking addBusDepo = busBookingServices.addBusBooking(mpBusBooking);
            System.out.println(addBusDepo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusDepo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusBooking Details
    @GetMapping("/getBooking" )
    public ResponseEntity<Map<String, Object>> getBusBooking(){

        Map<String, Object> list =null;
        try {

            list= busBookingServices.getBusBooking();
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

    //Get BusBooking By Id
    @GetMapping("/GetBooking/{id}")
  public ResponseEntity<BusBooking> getBusBookingById(@PathVariable("id") Long id){
   BusBooking list =null;
      try {

           list= busBookingServices.getBusBookingById(id);

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


  //Update BusBooking By Id
  @PutMapping("/updateBooking/{id}")
  public ResponseEntity<BusBooking> updateBusDepoById(@RequestBody BusBooking busBooking,@PathVariable("id") Long id){

      try {

          BusBooking add = busBookingServices.updateBusBookingById(busBooking,id);
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

  // Delete BusBooking By Id
  @DeleteMapping("/deleteBooking/{id}")
  public ResponseEntity<BusBooking> deleteBusBookingById(@PathVariable("id") Long id){

      try {

          BusBooking add = busBookingServices.deleteBusBookingById(id);
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