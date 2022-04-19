package com.example.services;

import java.util.List;

import com.example.dao.BusDetailRepository;
import com.example.entites.BusDetail;

import org.springframework.beans.factory.annotation.Autowired;
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
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return busDetail;
    }

    // Get All BusDetail
    public List<BusDetail> getBusDetail()
    {
      
        List<BusDetail> list =null;
        try {
            
            list = busDetailRepository.findAll();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }


    // Get BusDetail By Id
    public BusDetail getBusDetailById(Long id)
    {
      
        BusDetail list =null;
        try {
            
            list = busDetailRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
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
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

     //Delete BusDetail By Id
     public BusDetail deleteBusDetailById(Long id){

       BusDetail byId = null;
       try{
           byId = busDetailRepository.getById(id);
           busDetailRepository.deleteById(id);

       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return byId;
     }
}
