package com.example.controller;

import java.util.List;
import java.util.Map;

import com.example.Model.SourceDestinationModel;
import com.example.entites.SourceDestination;
import com.example.response.ApiResponse1;
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
    public ResponseEntity<ApiResponse1> addSource(@RequestBody SourceDestination sourceDestination){


           sourceDestinationService.addSource(sourceDestination);

          
               
           return new ResponseEntity<ApiResponse1>(new ApiResponse1("Data added successfully!"),HttpStatus.CREATED);
    }

     // Get SourceDestination Details
     @GetMapping("/getSourceDestination" )
     public ResponseEntity<List<SourceDestinationModel>> getSource(){
 
        
        

           List<SourceDestinationModel>  list= sourceDestinationService.getSource();

             return ResponseEntity.status(HttpStatus.OK).body(list);
       
     }

     //Get SourceDestination By Id
     @GetMapping("/getSourceDestination/{id}")
   public ResponseEntity<SourceDestinationModel> getSourceById(@PathVariable("id") Long id){
    SourceDestinationModel list =null;
       

            list= sourceDestinationService.getSourceById(id);

    
            return ResponseEntity.status(HttpStatus.OK).body(list); 
       
   }


   //Update SourceDestination By Id
   @PutMapping("/updateSourceDestination/{id}")
   public ResponseEntity<ApiResponse1> updateSourceById(@RequestBody SourceDestination sourceDestination,@PathVariable("id") Long id){

       

          sourceDestinationService.updateSourceById(sourceDestination,id);
        
           return new ResponseEntity<ApiResponse1>(new ApiResponse1("SourceDestination data updated successfully!!"),
                HttpStatus.OK);
       
   }

   // Delete SourceDestination By Id
   @DeleteMapping("/deleteSourceDestination/{id}")
   public ResponseEntity<SourceDestination> deleteSourceById(@PathVariable("id") Long id){

       try {

           SourceDestination add = sourceDestinationService.deleteSourceById(id);
           if(add==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
           return ResponseEntity.status(HttpStatus.OK).build(); 
       } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
   }
}
