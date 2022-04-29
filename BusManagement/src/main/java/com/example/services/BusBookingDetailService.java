package com.example.services;

import java.util.List;

import com.example.dao.BusBookingDetailRepository;

import com.example.entites.BusBookingDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusBookingDetailService {
   
    @Autowired
    private BusBookingDetailRepository busBookingDetailRepository;
    
    // Add BusBookingDetail Details
    public BusBookingDetail addBusBookingDetail(BusBookingDetail busBookingDetail){

         
        try {
            
            BusBookingDetail save = busBookingDetailRepository.save(busBookingDetail);
            System.out.println(save);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return busBookingDetail;
    }

    // Get All BusBookingDetail
    public List<BusBookingDetail> getBusBookingDetail()
    {
      
        List<BusBookingDetail> list =null;
        try {
            
            list = busBookingDetailRepository.findAll();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }


    // Get BusBookingDetail By Id
    public BusBookingDetail getBusBookingDetailById(Long id)
    {
      
        BusBookingDetail list =null;
        try {
            
            list = busBookingDetailRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update BusBookingDetail By Id
     public BusBookingDetail updateBusBookingDetailById(BusBookingDetail bus,Long id)
     {
       
       BusBookingDetail list =null;
         try {
            list = busBookingDetailRepository.getById(id);  
           // list.setBusBookingId(bus.getBusBookingId());
             list.setCustomerId(bus.getCustomerId());
             list.setSeatNumber(bus.getSeatNumber());
             list.setPaymentDate(bus.getPaymentDate());
             list.setPaymentId(bus.getPaymentId());
             list.setPaymentAmount(bus.getPaymentAmount());
             list.setPaymentType(bus.getPaymentType());
             list.setStatus(bus.getStatus());

             busBookingDetailRepository.save(list);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete BusBookingDetail By Id
     public BusBookingDetail deleteBusBookingDetailById(Long id){

       BusBookingDetail byId = null;
       try{
           byId = busBookingDetailRepository.getById(id);
           busBookingDetailRepository.deleteById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
