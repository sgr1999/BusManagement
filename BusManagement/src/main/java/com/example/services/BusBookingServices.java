package com.example.services;

import com.example.dao.BusBookingRepository;
import com.example.entites.BusBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusBookingServices {
    
    @Autowired
    private BusBookingRepository busBookingRepository;


    public BusBooking addBooking(BusBooking booking){

        return booking;
    }
    
}
