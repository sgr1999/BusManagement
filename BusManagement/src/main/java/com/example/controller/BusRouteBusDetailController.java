package com.example.controller;

import java.util.List;

import com.example.entites.BusRouteBusDetail;
import com.example.services.BusRouteBusDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusRouteBusDetailController {
    
    @Autowired
    private BusRouteBusDetailService busRouteBusDetailService;

    //Add BusRouteBusDetail Details
    @PostMapping("/busRouteBusDetail")
    public ResponseEntity<BusRouteBusDetail> addBusRoute(@RequestBody BusRouteBusDetail busRouteBusDetail){

        try {

            BusRouteBusDetail addBusDepo = busRouteBusDetailService.addBusRoute(busRouteBusDetail);
            System.out.println(addBusDepo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusDepo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get BusRouteBusDetail Details
    @GetMapping("/busRouteBusDetail" )
    public ResponseEntity<List<BusRouteBusDetail>> getBusRoute(){

       List<BusRouteBusDetail> list =null;
        try {

            list= busRouteBusDetailService.getBusRoute();
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

    //Get BusRouteBusDetail By Id
    @GetMapping("/busRouteBusDetail/{id}")
  public ResponseEntity<BusRouteBusDetail> getBusDepoById(@PathVariable("id") Long id){
   BusRouteBusDetail list =null;
      try {

           list= busRouteBusDetailService.getBusRouteById(id);

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


  //Update BusRouteBusDetail By Id
  @PutMapping("/busRouteBusDetail/{id}")
  public ResponseEntity<BusRouteBusDetail> updateBusRouteById(@RequestBody BusRouteBusDetail busRouteBusDetail,@PathVariable("id") Long id){

      try {

          BusRouteBusDetail add = busRouteBusDetailService.updateBusRouteById(busRouteBusDetail,id);
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

  // Delete BusRouteBusDetail By Id
  @DeleteMapping("/busRouteBusDetail/{id}")
  public ResponseEntity<BusRouteBusDetail> deleteBusRouteById(@PathVariable("id") Long id){

      try {

          BusRouteBusDetail add = busRouteBusDetailService.deleteBusRouteById(id);
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
