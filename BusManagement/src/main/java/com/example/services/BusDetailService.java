package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.BusDetailModel;
import com.example.dao.BusDetailRepository;
import com.example.entites.BusDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class BusDetailService {
    
    @Autowired
    private BusDetailRepository busDetailRepository;

    // Add BusDetail Details
    public BusDetail addBusDetail(BusDetail busDetail){

         
        try {
            
            BusDetail save = busDetailRepository.save(busDetail);
            System.out.println(save);

            return save;
        } 
        catch(DataIntegrityViolationException ee){
            System.out.println("--#--Bus Number already present in database OR busDepoId, BusTypeId not found in table--#--");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All BusDetail
    public List<BusDetailModel> getBusDetail()
    {
      
        List<BusDetail> list =null;
        List<BusDetailModel> list1 = new ArrayList<>();
        try {
            
            list = busDetailRepository.findAll();

            list.forEach(e->{
                list1.add(new BusDetailModel(e.getBusNumber(), e.getNoOfSeat(), e.getStatus(), e.getBusTypeId().getBusType(), e.getBusDepoId().getBusDepoName(), e.getBusDepoId().getBusDepoAddress()));
            });
            return list1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }


    // Get BusDetail By Id
    public Map<String,Object> getBusDetailById(Long id)
    {
      
        BusDetail list =null;
        Map<String,Object> map = new HashMap<>();
        try {
            
            list = busDetailRepository.getById(id);
            map.put("busNumber", list.getBusNumber());
            map.put("noOfSeat", list.getNoOfSeat());
            map.put("status", list.getStatus());
            map.put("busType", list.getBusTypeId().getBusType());
            map.put("busDepoName", list.getBusDepoId().getBusDepoName());
            map.put("busDepoAddress", list.getBusDepoId().getBusDepoAddress());
           
            return map;
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

     // Update BusDetail By Id
     public BusDetail updateBusDetailById(BusDetail busDetail,Long id)
     {
       
       BusDetail list =null;
         try {
            list = busDetailRepository.getById(id);  
             list.setBusDepoId(busDetail.getBusDepoId());
             list.setBusNumber(busDetail.getBusNumber());
             list.setBusTypeId(busDetail.getBusTypeId());
             list.setNoOfSeat(busDetail.getNoOfSeat());
             list.setStatus(busDetail.getStatus());

             busDetailRepository.save(list);
             return list;
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return null;
     }

     //Delete BusDetail By Id
     public BusDetail deleteBusDetailById(Long id){

       BusDetail byId = null;
       try{
           byId = busDetailRepository.getById(id);
           busDetailRepository.deleteById(id);
        return byId;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return null;
     }
}
