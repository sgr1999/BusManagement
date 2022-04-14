package com.example.controller;

import java.util.List;

import com.example.entites.SourceDestination;
import com.example.services.SourceDestinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SourceDestinationController {
    
    @Autowired
    private SourceDestinationService sourceDestinationService;

    // @GetMapping("/getSource")
    // public ResponseEntity<List<SourceDestination>> getSource(){

    //     try {
    //       //  List<SourceDestination> source = sourceDestinationService.getSource();
    //         System.out.println(source);
    //         return ResponseEntity.status(HttpStatus.ACCEPTED).body(source);

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         System.out.println(e);
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }
}
