package com.example.services;

import java.util.List;

import com.example.Model.BusRouteBookingLocationModel;
import com.example.dao.BusRouteBookingLocationRepository;
import com.example.entites.BusRouteBookingLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusRouteBookingLocationService {
    
    @Autowired
    private BusRouteBookingLocationRepository busRouteBookingLocationRepository;

    // Add BusRouteBookingLocation Details
    public BusRouteBookingLocation addBusLocation(BusRouteBookingLocation bus){

         
        try {
            
            BusRouteBookingLocation save = busRouteBookingLocationRepository.save(bus);
            System.out.println(save);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return bus;
    }

    // Get All BusRouteBookingLocation
    public List<BusRouteBookingLocationModel> getBuslocation()
    {
      
        List<BusRouteBookingLocationModel> list =null;
        try {
            
            list = busRouteBookingLocationRepository.findData();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }


    // Get BusRouteBookingLocation By Id
    public BusRouteBookingLocation getBusLocationById(Long id)
    {
      
        BusRouteBookingLocation list =null;
        try {
            
            list = busRouteBookingLocationRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update BusRouteBookingLocation By Id
     public BusRouteBookingLocation updateBusLocationById(BusRouteBookingLocation bus,Long id)
     {
       
       BusRouteBookingLocation list =null;
         try {
            list = busRouteBookingLocationRepository.getById(id);  
             list.setBusDepoRouteId(bus.getBusDepoRouteId());
             list.setCityId(bus.getCityId());
             list.setArrivalTime(bus.getArrivalTime());
             list.setRouteSequence(bus.getRouteSequence());
             list.setBookingAllowed(bus.getBookingAllowed());

             busRouteBookingLocationRepository.save(list);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete BusRouteBookingLocation By Id
     public BusRouteBookingLocation deleteBusLocationById(Long id){

       BusRouteBookingLocation byId = null;
       try{
           byId = busRouteBookingLocationRepository.getById(id);
           busRouteBookingLocationRepository.deleteById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
