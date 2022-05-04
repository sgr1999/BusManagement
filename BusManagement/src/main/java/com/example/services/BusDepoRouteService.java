package com.example.services;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.Model.BusDepoRouteModel;
import com.example.dao.BusDepoRouteRepository;
import com.example.dao.CityRepository;
import com.example.dao.SourceDestinationRepository;
import com.example.entites.BusDepoRoute;
import com.example.entites.SourceDestination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class BusDepoRouteService {
    
    @Autowired
    private BusDepoRouteRepository busDepoRouteRepository;

    @Autowired 
    private SourceDestinationRepository sourceDestinationRepository;

    @Autowired
    private CityRepository cityRepository;

    // Add BusDepoRoute Details
    public BusDepoRoute addBusDepoRoute(BusDepoRoute busDepoRoute){

         
        try {
            sourceDestinationRepository.findById(busDepoRoute.getSource());
            sourceDestinationRepository.findById(busDepoRoute.getDestination());

            BusDepoRoute save = busDepoRouteRepository.save(busDepoRoute);
           
            return save;
            
        } 
        catch(DataIntegrityViolationException ee){
            System.out.println("--#--Check ArrivalTime and busDepartureTime may be that alredy present in database OR busDepoId, source, destination can not be found in database--#--");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All BusDepoRoute
    public List<BusDepoRouteModel> getBusDepoRoute()
    {
      
        List<BusDepoRoute> list =null;
        List<BusDepoRouteModel> list1 = new ArrayList<>();
       
        try {
            
            list = busDepoRouteRepository.findAll();
            System.out.println("-------------"+list);
            list.forEach(e->{
                SourceDestination source = sourceDestinationRepository.getById(e.getSource());
                SourceDestination destination = sourceDestinationRepository.getById(e.getDestination());
                list1.add(new BusDepoRouteModel(source.getCityId().getCityName(), destination.getCityId().getCityName(), e.getTotalKm(), e.getBusDepartureTime(), e.getBusArrivalTime(), e.getBusDepoId().getBusDepoName(), e.getBusDepoId().getBusDepoAddress()));
            });
            return list1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }


    // Get BusDepoRoute By Id
    public Map<String,Object> getBusDepoRouteById(Long id)
    {
      
        BusDepoRoute list =null;
        BusDepoRouteModel list1 = null;
        Map<String,Object> map = new HashMap<>();
        try {
            
            list = busDepoRouteRepository.getById(id);

            SourceDestination source = sourceDestinationRepository.getById(list.getSource());
            SourceDestination destination = sourceDestinationRepository.getById(list.getDestination());

            map.put("source", source.getCityId().getCityName());
            map.put("destination", destination.getCityId().getCityName());
            map.put("totalKm", list.getTotalKm());
            map.put("busDepartureTime", list.getBusDepartureTime());
            map.put("busArrivalTime", list.getBusArrivalTime());
            map.put("busDepoName", list.getBusDepoId().getBusDepoName());
            map.put("busDepoAddress", list.getBusDepoId().getBusDepoAddress());
            return map;
        }
        catch(EmptyResultDataAccessException ee){
            System.out.println("busDepoRoute id does not exist in table");
        }
        
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

     // Update BusDepoRoute By Id
     public BusDepoRoute updateBusDepoRouteById(BusDepoRoute busDepoRoute,Long id)
     {
       
       BusDepoRoute list =null;
         try {
            list = busDepoRouteRepository.getById(id);

            list.setBusDepoId(busDepoRoute.getBusDepoId());
            list.setSource(busDepoRoute.getSource());
            list.setDestination(busDepoRoute.getDestination());
            list.setTotalKm(busDepoRoute.getTotalKm());
            list.setBusDepartureTime(busDepoRoute.getBusDepartureTime());
            list.setBusArrivalTime(busDepoRoute.getBusArrivalTime());

             busDepoRouteRepository.save(list);
             
             return list;
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return null;
     }

     //Delete BusDepoRoute By Id
     public BusDepoRoute deleteBusDepoRouteById(Long id){

       BusDepoRoute byId = null;
       try{
           byId = busDepoRouteRepository.getById(id);
           busDepoRouteRepository.deleteById(id);

           return byId;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return null;
     }
}
