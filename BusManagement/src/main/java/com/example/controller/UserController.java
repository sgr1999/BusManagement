package com.example.controller;

import com.example.dao.BusBookingRepository;
import com.example.entites.BusBooking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private BusBookingRepository busBookingRepository;

  



    // busBooking 
    @PostMapping("/busBooking")
    public ResponseEntity<BusBooking> addBooking(@RequestBody BusBooking busBooking) {

        BusBooking b = null;

        try {

            BusBooking save = busBookingRepository.save(b);
            System.out.println(save);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    

}
