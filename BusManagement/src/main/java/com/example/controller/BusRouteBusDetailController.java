package com.example.controller;

import java.util.List;
import java.util.Map;

import com.example.Model.BusRouteBusDetailModel;
import com.example.entites.BusRouteBusDetail;
import com.example.services.BusRouteBusDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/busRouteBusDetail")
public class BusRouteBusDetailController {
    
    @Autowired
    private BusRouteBusDetailService busRouteBusDetailService;

    //Add BusRouteBusDetail Details
    @PostMapping("/addBusRouteBusDetail")
    public ResponseEntity<BusRouteBusDetail> addBusRoute(@RequestBody BusRouteBusDetail busRouteBusDetail){

        try {

            BusRouteBusDetail addBusDepo = busRouteBusDetailService.addBusRoute(busRouteBusDetail);
            
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

    // Get BusRouteBusDetail Details
    @GetMapping("/getBusRouteBusDetail" )
    public ResponseEntity<List<BusRouteBusDetailModel>> getBusRoute(){

       List<BusRouteBusDetailModel> list =null;
        try {

            list= busRouteBusDetailService.getBusRoute();
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

    //Get BusRouteBusDetail By Id
    @GetMapping("/getBusRouteBusDetail/{id}")
  public ResponseEntity<Map<String,Object>> getBusDepoById(@PathVariable("id") Long id){
    Map<String,Object> list =null;
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
  @PutMapping("/updateBusRouteBusDetail/{id}")
  public ResponseEntity<BusRouteBusDetail> updateBusRouteById(@RequestBody BusRouteBusDetail busRouteBusDetail,@PathVariable("id") Long id){

      try {

          BusRouteBusDetail add = busRouteBusDetailService.updateBusRouteById(busRouteBusDetail,id);
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

  // Delete BusRouteBusDetail By Id
  @DeleteMapping("/deleteBusRouteBusDetail/{id}")
  public ResponseEntity<BusRouteBusDetail> deleteBusRouteById(@PathVariable("id") Long id){

      try {

          BusRouteBusDetail add = busRouteBusDetailService.deleteBusRouteById(id);
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
