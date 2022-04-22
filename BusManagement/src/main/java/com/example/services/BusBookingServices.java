package com.example.services;

import java.util.List;

import com.example.dao.BusBookingRepository;
import com.example.entites.BusBooking;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class BusBookingServices {
    
    @Autowired
    private BusBookingRepository busBookingRepository;


   // Add BusBooking Details
   public BusBooking addBusBooking(BusBooking busBooking){

    Long totalSeat= (long) 40;
    Long bookedSeat =null;
    Long bookingCount =0L;
    try {
         bookingCount = busBookingRepository.findBookingSeats();
         Long bookingSeat = busBooking.getBookingSeat();

        bookedSeat  = bookingCount+bookingSeat;

        Long avaliableSeat =totalSeat- bookedSeat; 
      
        
        
        busBooking.setTotalSeat(totalSeat);
        busBooking.setAvaliableSeat(avaliableSeat);
        
        BusBooking save = busBookingRepository.save(busBooking);
        busBooking.setBookingSeat(bookedSeat);
        System.out.println(save);
        
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
    }
    return busBooking;
}

// Get All BusBooking
public List<BusBooking> getBusBooking()
{
  
    List<BusBooking> list =null;
    try {
        
        list = busBookingRepository.findAll();

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
    }
    return list;
}


// Get BusBooking By Id
public BusBooking getBusBookingById(Long id)
{
  
    BusBooking list =null;
    try {
        
        list = busBookingRepository.getById(id);
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
    }
    return list;
}

 // Update BusBooking By Id
 public BusBooking updateBusBookingById(BusBooking bus,Long id)
 {
   
   BusBooking list =null;
     try {
        list = busBookingRepository.getById(id);  
         list.setBusDepoRouteId(bus.getBusDepoRouteId());
         list.setBusRouteBusDetailId(bus.getBusRouteBusDetailId());
         list.setBookingNumber(bus.getBookingNumber());
         list.setTotalSeat(bus.getTotalSeat());
         list.setBookingSeat(bus.getBookingSeat());
         list.setAvaliableSeat(bus.getAvaliableSeat());
         list.setTravelingDate(bus.getTravelingDate());

         busBookingRepository.save(list);
     } catch (Exception e) {
         e.printStackTrace();
         System.out.println(e);
     }
     return list;
 }

 //Delete BusBooking By Id
 public BusBooking deleteBusBookingById(Long id){

   BusBooking byId = null;
   try{
       byId = busBookingRepository.getById(id);
       busBookingRepository.deleteById(id);

   }
   catch(Exception e){
       e.printStackTrace();
       System.out.println(e);
   }

   return byId;
 }
}
