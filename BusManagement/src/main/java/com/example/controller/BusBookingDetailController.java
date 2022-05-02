package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.entites.BusBookingDetail;
import com.example.services.BusBookingDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/busBookingDetail")
public class BusBookingDetailController {
    
    @Autowired
    private BusBookingDetailService busBookingDetailService;

    //Add BusBookingDetail Details
    @PostMapping("/addBookingDetail")
    public ResponseEntity<BusBookingDetail> addBusDepo(@Valid @RequestBody BusBookingDetail busBookingDetail){

        try {

            BusBookingDetail addBusDepo = busBookingDetailService.addBusBookingDetail(busBookingDetail);
            System.out.println(addBusDepo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusDepo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusBookingDetail Details
    @GetMapping("/getAllBookingDetail" )
    public ResponseEntity<List<BusBookingDetail>> getBusBookingDetail(){

       List<BusBookingDetail> list =null;
        try {

            list= busBookingDetailService.getBusBookingDetail();
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

    //Get BusBookingDetail By Id
    @GetMapping("/getBookingDetail/{id}")
  public ResponseEntity<BusBookingDetail> getBusDepoById(@PathVariable("id") Long id){
   BusBookingDetail list =null;
      try {

           list= busBookingDetailService.getBusBookingDetailById(id);

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


  //Update BusBookingDetail By Id
  @PutMapping("/updateBookingDetail/{id}")
  public ResponseEntity<BusBookingDetail> updateBusDepoById(@RequestBody BusBookingDetail busBookingDetail,@PathVariable("id") Long id){

      try {

          BusBookingDetail add = busBookingDetailService.updateBusBookingDetailById(busBookingDetail,id);
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

  // Delete BusBookingDetail By Id
  @DeleteMapping("/deleteBookingDetail/{id}")
  public ResponseEntity<BusBookingDetail> deleteBusDepoById(@PathVariable("id") Long id){

      try {

          BusBookingDetail add = busBookingDetailService.deleteBusBookingDetailById(id);
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
