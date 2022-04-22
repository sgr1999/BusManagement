package com.example.dao;

import com.example.entites.BusBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusBookingRepository extends JpaRepository<BusBooking, Long>{
    
    @Query("select sum(b.bookingSeat) from BusBooking b")
    public Long findBookingSeats();


}
