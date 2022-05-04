package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.Model.DistrictModel;
import com.example.dao.DistrictRepository;
import com.example.dao.StateRepository;
import com.example.entites.District;
import com.example.entites.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class DistrictService {
    

    @Autowired
    private DistrictRepository districtRepository;
    
    @Autowired
    private StateRepository stateRepository;


    //Add District 
    public District addDistrict(Map<String,Object> mpDistrict)
    {
        District save = null;
        try {

            Long districtCode = Long.parseLong((String)mpDistrict.get("districtCode"));
            String districtName = (String) mpDistrict.get("districtName");
            Long stateId = Long.parseLong((String)mpDistrict.get("stateId"));
            Optional<State> stateId1 = stateRepository.findById(stateId);
            
            

            District district = new District();

            district.setDistrictCode(districtCode);
            district.setDistrictName(districtName);

            if(!stateId1.isEmpty())
            {
                district.setStateId(stateId1.get());
            }
            else{
                throw new Exception("state id does not exist in database");
            }

           save = districtRepository.save(district);
        }
        catch(DataIntegrityViolationException e1){
            System.out.println("--District code or District name already does exist in database");
        }
        catch(NumberFormatException e2){
            System.out.println("district code or district name can not be null");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return save;
    }

    // Get All District
    public List<DistrictModel> getDistrict()
    {
      
        List<DistrictModel> data=null;
        try {

             data = districtRepository.getData();
           System.out.println(data);
            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return data;
    }

    // Get District By Id
    public DistrictModel getDistrictById(Long id)
    {
      
        DistrictModel list =null;
        try {
            
            list = districtRepository.getDataById(id);

            System.out.println("--------------------"+list);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update District By Id
     public District updateDistrictById(District district,Long id)
     {
       
       District list =null;
         try {
             list = districtRepository.getById(id);
             list.setDistrictCode(district.getDistrictCode());
             list.setDistrictName(district.getDistrictName());

      
                 
                 list=  districtRepository.save(list);
            
          return list;
         } 
         catch(EntityNotFoundException e1){
             System.out.println("--district id not present in database please check it properly");
         }
         catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return null;
     }

     //Delete By Id
     public District deleteDistrictById(Long id){
       District byId = null;
       try{
          
               byId = districtRepository.getById(id);
              // System.out.println("------------service-------"+byId);
               districtRepository.deleteById(id);
               return byId;
          
       }
       catch(EmptyResultDataAccessException e1){
           System.out.println("--#--district id not present in database check it properly--#--");
           return null;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
           return null;
       }

     }
}
