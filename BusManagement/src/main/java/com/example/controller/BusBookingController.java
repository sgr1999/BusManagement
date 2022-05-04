package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.example.Model.BusBookingModel;
import com.example.entites.BusBooking;
import com.example.entites.BusBookingDetail;
import com.example.services.BusBookingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public ResponseEntity<BusBooking> addBusBooking(@Valid @RequestBody Map<String, Object> mpBusBooking){

        ResponseEntity<BusBooking> bus =null;
        try {

            String passengerName = (String) mpBusBooking.get("passengerName");
            String passengerAge = (String) mpBusBooking.get("passengerAge");
            String seatNumber = (String) mpBusBooking.get("seatNumber");
            String[] str = passengerName.split("[,]");
            String[] str1 = passengerAge.split("[,]");
            String[] seat = seatNumber.split("[,]");
        
            if (str.length != str1.length || str.length != seat.length) {
                
                throw new Exception("check field , Name , Age , SeatNumber have to same for per person");
            }
           
            BusBookingDetail busBookingDetail = new BusBookingDetail();
            busBookingDetail.setTransactionId(UUID.randomUUID().toString().toUpperCase().split("-")[0]);
            busBookingDetail.setPaymentId(UUID.randomUUID().toString().split("-")[0]);

           
            int c = 0;
            
            for(String passenger : str){

                Long age = Long.parseLong(str1[c].trim());
                Long seatN = Long.parseLong(seat[c].trim());
             
             busBookingDetail.setPassengerAge(age);
             busBookingDetail.setSeatNumber(seatN);
             busBookingDetail.setPassengerName(passenger.trim());
            bus =  busBookingServices.addBusBooking(mpBusBooking,busBookingDetail);
             c++;

            }   

            if (bus !=null) {
                
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
   
        } 
        catch(DataIntegrityViolationException e1){
            System.out.println("bus seat already booked , Select other seatNumber");
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusBooking Details
    @GetMapping("/getBooking" )
    public ResponseEntity<List<BusBookingModel>> getBusBooking(){

       
        try {

          List<BusBookingModel>  list= busBookingServices.getBusBooking();
           if(list.size()<=0){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }

            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Get BusBooking By Id
    @GetMapping("/getBooking/{id}")
  public ResponseEntity<Map<String,Object>> getBusBookingById(@PathVariable("id") Long id){
    Map<String,Object> list =null;
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
          return ResponseEntity.status(HttpStatus.OK).build(); 
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
          return ResponseEntity.status(HttpStatus.OK).build(); 
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
  }
}