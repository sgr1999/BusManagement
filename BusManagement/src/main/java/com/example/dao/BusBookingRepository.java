package com.example.dao;

import com.example.entites.BusBooking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BusBookingRepository extends JpaRepository<BusBooking, Integer>{
    
}
