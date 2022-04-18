package com.example.controller;

import com.example.entites.BusDepo;
import com.example.services.BusDepoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BusDepoController {
    
    @Autowired
    private BusDepoService busDepoService;

    @PostMapping("/busDepo")
    public ResponseEntity<BusDepo> addBusDepo(@RequestBody BusDepo busDepo){

        try {

            BusDepo addBusDepo = busDepoService.addBusDepo(busDepo);
            System.out.println(addBusDepo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addBusDepo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
