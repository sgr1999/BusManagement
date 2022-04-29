package com.example.controller;

import java.util.List;
import java.util.Map;

import com.example.Model.SourceDestinationModel;
import com.example.entites.SourceDestination;
import com.example.services.SourceDestinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sourceDestination")
public class SourceDestinationController {
    
    @Autowired
    private SourceDestinationService sourceDestinationService;


    // Add SourceDestination
    @PostMapping("/addSourceDestination" )
    public ResponseEntity<SourceDestination> addSource(@RequestBody SourceDestination sourceDestination){

        try {

           SourceDestination add = sourceDestinationService.addSource(sourceDestination);
           System.out.println(add);
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

     // Get SourceDestination Details
     @GetMapping("/getSourceDestination" )
     public ResponseEntity<Map<String, Object>> getSource(){
 
        Map<String, Object> list =null;
         try {

             list= sourceDestinationService.getSource();
            if(list.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

             System.out.println(list);
             return ResponseEntity.status(HttpStatus.OK).body(list);
         } catch (Exception e) {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }

     //Get SourceDestination By Id
     @GetMapping("/getSourceDestination/{id}")
   public ResponseEntity<SourceDestination> getSourceById(@PathVariable("id") Long id){
    SourceDestination list =null;
       try {

            list= sourceDestinationService.getSourceById(id);

           if(list==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
           return ResponseEntity.status(HttpStatus.OK).body(list); 
       } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
   }


   //Update SourceDestination By Id
   @PutMapping("/updateSourceDestination/{id}")
   public ResponseEntity<SourceDestination> updateSourceById(@RequestBody SourceDestination sourceDestination,@PathVariable("id") Long id){

       try {

           SourceDestination add = sourceDestinationService.updateSourceById(sourceDestination,id);
           if(add==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
           return ResponseEntity.status(HttpStatus.OK).body(add); 
       } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
   }

   // Delete SourceDestination By Id
   @DeleteMapping("/deleteSourceDestination/{id}")
   public ResponseEntity<SourceDestination> deleteSourceById(@PathVariable("id") Long id){

       try {

           SourceDestination add = sourceDestinationService.deleteSourceById(id);
           if(add==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
           return ResponseEntity.status(HttpStatus.OK).body(add); 
       } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
   }
}
