package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.BusBookingDetailModel;
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

            return save;
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All BusBookingDetail
    public List<BusBookingDetailModel> getBusBookingDetail()
    {
      
        List<BusBookingDetail> list =null;
        List<BusBookingDetailModel> list1 = new ArrayList<>();
        try {
            
            list = busBookingDetailRepository.findAll();

            list.forEach(e->{
                list1.add(new BusBookingDetailModel(e.getPassengerName(), e.getPassengerAge(), e.getTransactionId(), e.getSeatNumber(), e.getPaymentDate(), e.getPaymentId(), e.getPaymentAmount(), e.getPaymentType(), e.getStatus(), e.getCustomerId().getCustomerId()));
            });

            return list1;
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }


    // Get BusBookingDetail By Id
    public Map<String,Object> getBusBookingDetailById(Long id)
    {
      
        BusBookingDetail list =null;
        Map<String,Object> map = new HashMap<>();
        try {
            
            list = busBookingDetailRepository.getById(id);

            map.put("passengerName", list.getPassengerName());
            map.put("passengerAge", list.getPassengerAge());
            map.put("transactionId", list.getTransactionId());
            map.put("seatNumber", list.getSeatNumber());
            map.put("paymentDate", list.getPaymentDate());
            map.put("paymentId", list.getPaymentId());
            map.put("paymentAmount", list.getPaymentAmount());
            map.put("paymentType", list.getPaymentType());
            map.put("status", list.getStatus());
            map.put("customerId", list.getCustomerId().getCustomerId());

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

     // Update BusBookingDetail By Id
     public BusBookingDetail updateBusBookingDetailById(BusBookingDetail bus,Long id)
     {
       
       BusBookingDetail list =null;
         try {
            list = busBookingDetailRepository.getById(id);  
             //list.setBusBookingId(bus.getBusBookingId());
             list.setCustomerId(bus.getCustomerId());
             list.setSeatNumber(bus.getSeatNumber());
             list.setSeatNumber(bus.getSeatNumber());
             list.setPaymentAmount(bus.getPaymentAmount());
             list.setPaymentType(bus.getPaymentType());
             list.setStatus(bus.getStatus());

             busBookingDetailRepository.save(list);
             return list;
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return null;
     }

     //Delete BusBookingDetail By Id
     public BusBookingDetail deleteBusBookingDetailById(Long id){

       BusBookingDetail byId = null;
       try{
           byId = busBookingDetailRepository.getById(id);
           busBookingDetailRepository.deleteById(id);
        return byId;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return null;
     }
}
