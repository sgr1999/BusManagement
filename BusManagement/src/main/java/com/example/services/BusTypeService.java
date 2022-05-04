package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.BusTypeModel;
import com.example.Model.BusTypeModel1;
import com.example.dao.BusTypeRepository;
import com.example.entites.BusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
public class BusTypeService {
    
    @Autowired
    private BusTypeRepository busTypeRepository;

    // Add BusType Details
    public BusType addBusType(BusType busType){

         
        try {
            
            BusType save = busTypeRepository.save(busType);
            System.out.println(save);
            return save;
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All BusType
    public List<BusTypeModel1> getBusType()
    {
      
        List<BusTypeModel> list =null;
        List<BusType> list1 =null;
        List<BusTypeModel1> list2 =new ArrayList<>();
        try {
            
            list = busTypeRepository.findData();
            list1 = busTypeRepository.findAll();

            list1.forEach(e->{
                list2.add(new BusTypeModel1(e.getBusType(), e.getBusDepoId().getBusDepoName(), e.getBusDepoId().getBusDepoAddress()));
            });

            return list2;
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }


    // Get BusType By Id
    public Map<String,Object> getBusTypeById(Long id)
    {
      
        BusType list =null;
        Map<String,Object> map = new HashMap<>();
        try {
            
            list = busTypeRepository.getById(id);

            map.put("busType", list.getBusType());
            map.put("busDepoName", list.getBusDepoId().getBusDepoName());
            map.put("busDepoAddress", list.getBusDepoId().getBusDepoAddress());
            map.put("stateName", list.getBusDepoId().getStateId().getStateName());
            map.put("districtName", list.getBusDepoId().getDistrictId().getDistrictName());
            map.put("cityName", list.getBusDepoId().getCityId().getCityName());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
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

             return list;

         }
         catch(TransactionSystemException t){
             System.out.println("--#--enter data in BusType--#--");
         }
         catch(DataIntegrityViolationException d){
             System.out.println("--#--BusDepo Id does not exist in database , check it properly--#--");
         }
         catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return null;
     }

     //Delete BusType By Id
     public BusType deleteBusTypeById(Long id){

       BusType byId = null;
       try{
           byId = busTypeRepository.getById(id);
           busTypeRepository.deleteById(id);
        return byId;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return null;
     }
}
