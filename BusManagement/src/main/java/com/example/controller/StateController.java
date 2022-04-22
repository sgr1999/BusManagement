package com.example.controller;

import java.util.List;

import com.example.entites.State;
import com.example.services.StateService;

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
@RequestMapping("/state")
public class StateController {
    
    @Autowired
    private StateService stateService;

    // Add State
    @PostMapping("/addState" )
    public ResponseEntity<State> addState(@RequestBody State state){

        try {

           State add = stateService.addState(state);
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

     // Get State Details
     @GetMapping("/getState" )
     public ResponseEntity<List<State>> getState(){
 
         try {

           List<State> list = stateService.getState();

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


      // Get State By Id
    @GetMapping("/getState/{id}" )
    public ResponseEntity<State> getStateById(@PathVariable("id") Long id){

        try {

           State add = stateService.getStateById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


      // Update State By Id
      @PutMapping("/updateState/{id}" )
      public ResponseEntity<State> updateStateById(@RequestBody State state,@PathVariable("id") Long id){
  
          try {
  
             State add = stateService.updateStateById(state, id);

             add.setStateCode(state.getStateCode());
             add.setStateName(state.getStateName());
              return ResponseEntity.status(HttpStatus.CREATED).body(add);
          } catch (Exception e) {
              e.printStackTrace();
              System.out.println(e);
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
          }
      }

        // Delete State By Id
    @DeleteMapping("/deleteState/{id}" )
    public ResponseEntity<State> deleteStateById(@PathVariable("id") Long id){

        try {

           State add = stateService.deleteStateById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(add);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
