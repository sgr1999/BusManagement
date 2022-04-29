package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.BusDepoModel;
import com.example.dao.BusDepoRepository;
import com.example.dao.CityRepository;
import com.example.entites.BusDepo;
import com.example.entites.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusDepoService {
    
    @Autowired
    private BusDepoRepository busDepoRepository;

    @Autowired
    private CityRepository cityRepository;

    // Add BusDepo Details
    public BusDepo addBusDepo(BusDepo busDepo){

         
        try {
            
            BusDepo save = busDepoRepository.save(busDepo);
            System.out.println(save);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return busDepo;
    }

    // Get All BusDepo
    public Map<String,Object> getBusDepo()
    {
      
        List<BusDepoModel> list =null;
        List<BusDepoModel> list1 =null;
        Map<String,Object> map = new HashMap<>();
        try {
            
            list = busDepoRepository.findData();

            Long count = busDepoRepository.countData();

            System.out.println("data-------------"+count);

            list.forEach(e->{
                map.put("busDepoName", e.getBusDepoName());
                map.put("busDepoAddress", e.getBusDepoAddress());
                map.put("stateName", e.getStateName());
                map.put("districtName", e.getDistrictName());
                map.put("cityName", e.getCityName());

            });

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return map;
    }


    // Get BusDepo By Id
    public BusDepo getBusDepoById(Long id)
    {
      
        BusDepo list =null;
        try {

            
         
            list = busDepoRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update BusDepo By Id
     public BusDepo updateBusDepoById(BusDepo busDepo,Long id)
     {
       
       BusDepo list =null;
         try {
            list = busDepoRepository.getById(id);  
             list.setBusDepoName(busDepo.getBusDepoName());
             list.setBusDepoAddress(busDepo.getBusDepoAddress());
             list.setStateId(busDepo.getStateId());
             list.setDistrictId(busDepo.getDistrictId());
             list.setCityId(busDepo.getCityId());

             busDepoRepository.save(list);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete BusDepo By Id
     public BusDepo deleteBusDepoById(Long id){

       BusDepo byId = null;
       try{
           byId = busDepoRepository.getById(id);
           busDepoRepository.deleteById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
