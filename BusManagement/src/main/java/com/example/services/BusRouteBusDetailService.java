package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.BusRouteBusDetailRepository;
import com.example.entites.BusDetail;
import com.example.entites.BusRouteBusDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusRouteBusDetailService {
    
    @Autowired
    private BusRouteBusDetailRepository busRouteBusDetailRepository;

    // Add BusRouteBusDetail Details
    public BusRouteBusDetail addBusRoute(BusRouteBusDetail busRouteBusDetail){

        
        try {
           
            BusRouteBusDetail save = busRouteBusDetailRepository.save(busRouteBusDetail);
            System.out.println(save);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return busRouteBusDetail;
    }

    // Get All BusRouteBusDetail
    public List<BusRouteBusDetail> getBusRoute()
    {
      
        List<BusRouteBusDetail> list =null;
        try {
            
            list = busRouteBusDetailRepository.findAll();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }


    // Get BusRouteBusDetail By Id
    public BusRouteBusDetail getBusRouteById(Long id)
    {
      
        BusRouteBusDetail list =null;
        try {
            
            list = busRouteBusDetailRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update BusRouteBusDetail By Id
     public BusRouteBusDetail updateBusRouteById(BusRouteBusDetail busRouteBusDetail,Long id)
     {
       
       BusRouteBusDetail list =null;
         try {
            list = busRouteBusDetailRepository.getById(id);  
             list.setBusDepoRouteId(busRouteBusDetail.getBusDepoRouteId());
             list.setBusDetailId(busRouteBusDetail.getBusDetailId());

             busRouteBusDetailRepository.save(list);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete BusRouteBusDetail By Id
     public BusRouteBusDetail deleteBusRouteById(Long id){

       BusRouteBusDetail byId = null;
       try{
           byId = busRouteBusDetailRepository.getById(id);
           busRouteBusDetailRepository.deleteById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
