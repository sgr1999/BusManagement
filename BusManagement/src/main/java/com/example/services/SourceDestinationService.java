package com.example.services;

import java.util.List;

import com.example.dao.SourceDestinationRepository;
import com.example.entites.SourceDestination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SourceDestinationService {
    
    @Autowired
    private SourceDestinationRepository sourceDestinationRepository;

    //Add SourceDestination 
    public SourceDestination addSource(SourceDestination sourceDestination)
    {
        try {
            
           SourceDestination save = sourceDestinationRepository.save(sourceDestination);
           System.out.println(save);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return sourceDestination;
    }

    // Get All SourceDestination
    public List<SourceDestination> getSource()
    {
      
        List<SourceDestination> list =null;
        try {
            
            list = sourceDestinationRepository.findAll();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

    // Get SourceDestination By Id
    public SourceDestination getSourceById(Long id)
    {
      
        SourceDestination list =null;
        try {
            
            list = sourceDestinationRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update SourceDestination By Id
     public SourceDestination updateSourceById(SourceDestination source,Long id)
     {
       
       SourceDestination list =null;
         try {
             list.setCityId(source.getCityId());
             list.setDistrictId(source.getDistrictId());
             list.setStateId(source.getStateId());

             sourceDestinationRepository.save(list);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete SourceDestination By Id
     public SourceDestination deleteSourceById(Long id){

       SourceDestination byId = null;
       try{
           byId = sourceDestinationRepository.getById(id);
           sourceDestinationRepository.deleteById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
