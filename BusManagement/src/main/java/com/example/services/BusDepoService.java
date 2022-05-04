package com.example.services;

import java.sql.SQLIntegrityConstraintViolationException;
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
import org.springframework.dao.DataIntegrityViolationException;
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
            return save;
            
        }
        catch(DataIntegrityViolationException e2){
            System.out.println("Check Properly , busDepoName alredy exist in table or state Id, district Id, city Id not found in database");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All BusDepo
    public List<BusDepoModel> getBusDepo()
    {
      
        List<BusDepoModel> list =null;
      
        try {
            
            list = busDepoRepository.findData();
            return list;
          

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }


    // Get BusDepo By Id
    public BusDepoModel getBusDepoById(Long id)
    {
      
        BusDepoModel list =null;
        try {
            list = busDepoRepository.findDataById(id);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
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
             return list;
         } 
         catch(DataIntegrityViolationException ex2){
             System.out.println("add data properly you are someting messing");
         }
         catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return null;
     }

     //Delete BusDepo By Id
     public BusDepo deleteBusDepoById(Long id){

       BusDepo byId = null;
       try{
           byId = busDepoRepository.getById(id);
           busDepoRepository.deleteById(id);
        return byId;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return null;
     }
}
