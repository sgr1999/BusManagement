package com.example.controller;

import java.util.List;

import com.example.entites.State;
import com.example.services.StateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
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

}
