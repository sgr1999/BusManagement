package com.example.controller;

import java.util.List;

import com.example.entites.BusDetail;
import com.example.services.BusDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusDetailController {
    
    @Autowired
    private BusDetailService busDetailService;

    //Add BusDetail Details
    @PostMapping("/busDetail")
    public ResponseEntity<BusDetail> addBusDetail(@RequestBody BusDetail busDetail){

        try {

            BusDetail addBusDepo = busDetailService.addBusDetail(busDetail);
            System.out.println(addBusDepo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusDepo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusDetail Details
    @GetMapping("/busDetail" )
    public ResponseEntity<List<BusDetail>> getBusDetail(){

       List<BusDetail> list =null;
        try {

            list= busDetailService.getBusDetail();
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

    //Get BusDetail By Id
    @GetMapping("/busDetail/{id}")
  public ResponseEntity<BusDetail> getBusDetailById(@PathVariable("id") Long id){
   BusDetail list =null;
      try {

           list= busDetailService.getBusDetailById(id);

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


  //Update BusDetail By Id
  @PutMapping("/busDetail/{id}")
  public ResponseEntity<BusDetail> updateBusDetailById(@RequestBody BusDetail busDetail,@PathVariable("id") Long id){

      try {

          BusDetail add = busDetailService.updateBusDetailById(busDetail,id);
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

  // Delete BusDetail By Id
  @DeleteMapping("/busDetail/{id}")
  public ResponseEntity<BusDetail> deleteBusDetailById(@PathVariable("id") Long id){

      try {

          BusDetail add = busDetailService.deleteBusDetailById(id);
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
