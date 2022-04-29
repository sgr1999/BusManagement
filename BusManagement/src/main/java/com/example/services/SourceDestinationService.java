package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.SourceDestinationModel;
import com.example.dao.SourceDestinationRepository;
import com.example.entites.SourceDestination;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Map<String, Object> getSource()
    {
      
        List<SourceDestinationModel> list =new ArrayList<>();

        Map<String, Object> map = new HashMap<>();

        try {
            
            list = sourceDestinationRepository.findData();
    
            list.forEach(e->{

                map.put("cityCode", e.getCityCode());
                map.put("cityName", e.getCityName());
                map.put("districtCode",e.getDistrictCode());
                map.put("districtName", e.getDistrictName());
                map.put("stateCode",e.getStateCode());
                map.put("stateName", e.getStateName());
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return map;
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
             list = sourceDestinationRepository.getById(id);
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
