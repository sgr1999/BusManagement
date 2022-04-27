package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.Model.DistrictModel;
import com.example.dao.DistrictRepository;
import com.example.dao.StateRepository;
import com.example.entites.District;
import com.example.entites.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictService {
    

    @Autowired
    private DistrictRepository districtRepository;
    
    @Autowired
    private StateRepository stateRepository;


    //Add District 
    public District addDistrict(District district)
    {
        try {
            
            District save = districtRepository.save(district);
            System.out.println(save);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return district;
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

             districtRepository.save(list);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete By Id
     public District deleteDistrictById(Long id){

       District byId = null;
       try{
           districtRepository.deleteById(id);
           byId = districtRepository.getById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
