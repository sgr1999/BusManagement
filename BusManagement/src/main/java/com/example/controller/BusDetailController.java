package com.example.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.Model.BusDetailModel;
import com.example.entites.BusDetail;
import com.example.services.BusDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/busDetail")
public class BusDetailController {
    
    @Autowired
    private BusDetailService busDetailService;

    //Add BusDetail Details
    @PostMapping("/addBusDetail")
    public ResponseEntity<BusDetail> addBusDetail(@Valid @RequestBody BusDetail busDetail){

        try {

            BusDetail addBusDepo = busDetailService.addBusDetail(busDetail);
            
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

    // Get BusDetail Details
    @GetMapping("/getBusDetail" )
    public ResponseEntity<List<BusDetailModel>> getBusDetail(){

       List<BusDetailModel> list =null;
        try {

            list= busDetailService.getBusDetail();
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

    //Get BusDetail By Id
    @GetMapping("/getBusDetail/{id}")
  public ResponseEntity<Map<String,Object>> getBusDetailById(@PathVariable("id") Long id){
    Map<String,Object> list =null;
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
  @PutMapping("/updateBusDetail/{id}")
  public ResponseEntity<BusDetail> updateBusDetailById(@RequestBody BusDetail busDetail,@PathVariable("id") Long id){

      try {

          BusDetail add = busDetailService.updateBusDetailById(busDetail,id);
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

  // Delete BusDetail By Id
  @DeleteMapping("/deleteBusDetail/{id}")
  public ResponseEntity<BusDetail> deleteBusDetailById(@PathVariable("id") Long id){

      try {

          BusDetail add = busDetailService.deleteBusDetailById(id);
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
