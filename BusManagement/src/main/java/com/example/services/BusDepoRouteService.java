package com.example.services;

import java.util.List;

import com.example.dao.BusDepoRouteRepository;
import com.example.entites.BusDepoRoute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusDepoRouteService {
    
    @Autowired
    private BusDepoRouteRepository busDepoRouteRepository;

    // Add BusDepoRoute Details
    public BusDepoRoute addBusDepoRoute(BusDepoRoute busDepoRoute){

         
        try {
            
            BusDepoRoute save = busDepoRouteRepository.save(busDepoRoute);
            System.out.println(save);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return busDepoRoute;
    }

    // Get All BusDepoRoute
    public List<BusDepoRoute> getBusDepoRoute()
    {
      
        List<BusDepoRoute> list =null;
        try {
            
            list = busDepoRouteRepository.findAll();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }


    // Get BusDepoRoute By Id
    public BusDepoRoute getBusDepoRouteById(Long id)
    {
      
        BusDepoRoute list =null;
        try {
            
            list = busDepoRouteRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update BusDepoRoute By Id
     public BusDepoRoute updateBusDepoRouteById(BusDepoRoute busDepoRoute,Long id)
     {
       
       BusDepoRoute list =null;
         try {
            list = busDepoRouteRepository.getById(id);

            list.setBusDepoId(busDepoRoute.getBusDepoId());
            list.setSource(busDepoRoute.getSource());
            list.setDistination(busDepoRoute.getTotalKm());
            list.setBusDepartureTime(busDepoRoute.getBusDepartureTime());
            list.setBusArrivalTime(busDepoRoute.getBusArrivalTime());

             busDepoRouteRepository.save(list);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete BusDepoRoute By Id
     public BusDepoRoute deleteBusDepoRouteById(Long id){

       BusDepoRoute byId = null;
       try{
           byId = busDepoRouteRepository.getById(id);
           busDepoRouteRepository.deleteById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
