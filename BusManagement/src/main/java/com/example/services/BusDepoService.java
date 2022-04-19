package com.example.services;

import java.util.List;

import com.example.dao.BusDepoRepository;
import com.example.entites.BusDepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusDepoService {
    
    @Autowired
    private BusDepoRepository busDepoRepository;

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
    public List<BusDepo> getBusDepo()
    {
      
        List<BusDepo> list =null;
        try {
            
            list = busDepoRepository.findAll();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
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
