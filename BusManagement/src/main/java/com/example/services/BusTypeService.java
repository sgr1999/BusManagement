package com.example.services;

import java.util.List;

import com.example.dao.BusTypeRepository;
import com.example.entites.BusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusTypeService {
    
    @Autowired
    private BusTypeRepository busTypeRepository;

    // Add BusType Details
    public BusType addBusType(BusType busType){

         
        try {
            
            BusType save = busTypeRepository.save(busType);
            System.out.println(save);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return busType;
    }

    // Get All BusType
    public List<BusType> getBusType()
    {
      
        List<BusType> list =null;
        try {
            
            list = busTypeRepository.findAll();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }


    // Get BusType By Id
    public BusType getBusTypeById(Long id)
    {
      
        BusType list =null;
        try {
            
            list = busTypeRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update BusType By Id
     public BusType updateBusTypeById(BusType busType,Long id)
     {
       
       BusType list =null;
         try {
            list = busTypeRepository.getById(id);  

             list.setBusType(busType.getBusType());
             list.setBusDepoId(busType.getBusDepoId());

             busTypeRepository.save(list);

         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete BusType By Id
     public BusType deleteBusTypeById(Long id){

       BusType byId = null;
       try{
           byId = busTypeRepository.getById(id);
           busTypeRepository.deleteById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
