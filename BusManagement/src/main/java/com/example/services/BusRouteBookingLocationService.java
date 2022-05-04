package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.BusRouteBookingLocationModel;
import com.example.dao.BusRouteBookingLocationRepository;
import com.example.entites.BusRouteBookingLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class BusRouteBookingLocationService {
    
    @Autowired
    private BusRouteBookingLocationRepository busRouteBookingLocationRepository;

    // Add BusRouteBookingLocation Details
    public BusRouteBookingLocation addBusLocation(BusRouteBookingLocation bus){

         
        try {
            
            BusRouteBookingLocation save = busRouteBookingLocationRepository.save(bus);
            
            return save;
            
        } 
        catch(DataIntegrityViolationException ee){
            System.out.println("--#--City id might have alredy in database OR busDepoRouteId not found in database--#--");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All BusRouteBookingLocation
    public List<BusRouteBookingLocationModel> getBuslocation()
    {
      
        List<BusRouteBookingLocation> list =null;
        List<BusRouteBookingLocationModel> list1 = new ArrayList<>();
        try {
            
            list = busRouteBookingLocationRepository.findAll();
    
            list.forEach(e->{
                list1.add(new BusRouteBookingLocationModel(e.getArrivalTime(), e.getRouteSequence(), e.getBookingAllowed(), e.getBusDepoRouteId().getTotalKm(), e.getBusDepoRouteId().getBusDepartureTime(), e.getBusDepoRouteId().getBusArrivalTime(), e.getCityId().getCityName()));
            });
            return list1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }


    // Get BusRouteBookingLocation By Id
    public Map<String,Object> getBusLocationById(Long id)
    {
      
        BusRouteBookingLocation list =null;
        Map<String,Object> map= new HashMap<>();
        try {
            
            list = busRouteBookingLocationRepository.getById(id);

            map.put("arrivalTime", list.getArrivalTime());
            map.put("routeSequence", list.getRouteSequence());
            map.put("bookingAllowed", list.getBookingAllowed());
            map.put("totalKm", list.getBusDepoRouteId().getTotalKm());
            map.put("busDepartureTime", list.getBusDepoRouteId().getBusDepartureTime());
            map.put("busArrivalTime", list.getBusDepoRouteId().getBusArrivalTime());
            map.put("cityName", list.getCityId().getCityName());
           
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
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

             return list;
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return null;
     }

     //Delete BusRouteBookingLocation By Id
     public BusRouteBookingLocation deleteBusLocationById(Long id){

       BusRouteBookingLocation byId = null;
       try{
           byId = busRouteBookingLocationRepository.getById(id);
           busRouteBookingLocationRepository.deleteById(id);
        return byId;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return null;
     }
}
