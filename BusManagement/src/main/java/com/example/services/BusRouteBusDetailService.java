package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.BusRouteBusDetailModel;
import com.example.dao.BusRouteBusDetailRepository;
import com.example.dao.SourceDestinationRepository;
import com.example.entites.BusRouteBusDetail;
import com.example.entites.SourceDestination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class BusRouteBusDetailService {
    
    @Autowired
    private BusRouteBusDetailRepository busRouteBusDetailRepository;

    @Autowired
    private SourceDestinationRepository sourceDestinationRepository;

    // Add BusRouteBusDetail Details
    public BusRouteBusDetail addBusRoute(BusRouteBusDetail busRouteBusDetail){

        
        try {
           
            BusRouteBusDetail save = busRouteBusDetailRepository.save(busRouteBusDetail);
            System.out.println(save);

            return save;
            
        } 
        catch(DataIntegrityViolationException ee){
            System.out.println("--#--Check BusDepoRoute Id OR BusDetail Id that may be alredy does exist in table OR Not Found--#--");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All BusRouteBusDetail
    public List<BusRouteBusDetailModel> getBusRoute()
    {
      
        List<BusRouteBusDetail> list =null;
        List<BusRouteBusDetailModel> list1 = new ArrayList<>();
        try {
            
            list = busRouteBusDetailRepository.findAll();
    
            list.forEach(e->{
                SourceDestination source = sourceDestinationRepository.getById(e.getBusDepoRouteId().getSource());
                SourceDestination destination = sourceDestinationRepository.getById(e.getBusDepoRouteId().getDestination());
                
                list1.add(new BusRouteBusDetailModel(source.getCityId().getCityName(), destination.getCityId().getCityName(), e.getBusDepoRouteId().getTotalKm(), e.getBusDepoRouteId().getBusDepartureTime(), e.getBusDepoRouteId().getBusArrivalTime(), e.getBusDetailId().getBusNumber(), e.getBusDetailId().getNoOfSeat(),e.getBusDetailId().getBusTypeId().getBusType()));
            });
            return list1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }


    // Get BusRouteBusDetail By Id
    public Map<String,Object> getBusRouteById(Long id)
    {
      
        BusRouteBusDetail list =null;
        Map<String,Object> map = new HashMap<>();
        try {
            
            list = busRouteBusDetailRepository.getById(id);

            SourceDestination source = sourceDestinationRepository.getById(list.getBusDepoRouteId().getSource());
            SourceDestination destination = sourceDestinationRepository.getById(list.getBusDepoRouteId().getDestination());

            map.put("source", source.getCityId().getCityName());
            map.put("destination", destination.getCityId().getCityName());
            map.put("totalKm", list.getBusDepoRouteId().getTotalKm());
            map.put("busDepartureTime", list.getBusDepoRouteId().getBusDepartureTime());
            map.put("busArrivalTime", list.getBusDepoRouteId().getBusArrivalTime());
            map.put("busNumber", list.getBusDetailId().getBusNumber());
            map.put("noOfSeat", list.getBusDetailId().getNoOfSeat());
           
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

     // Update BusRouteBusDetail By Id
     public BusRouteBusDetail updateBusRouteById(BusRouteBusDetail busRouteBusDetail,Long id)
     {
       
       BusRouteBusDetail list =null;
         try {
            list = busRouteBusDetailRepository.getById(id);  
             list.setBusDepoRouteId(busRouteBusDetail.getBusDepoRouteId());
             list.setBusDetailId(busRouteBusDetail.getBusDetailId());

             busRouteBusDetailRepository.save(list);
             return list;
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return null;
     }

     //Delete BusRouteBusDetail By Id
     public BusRouteBusDetail deleteBusRouteById(Long id){

       BusRouteBusDetail byId = null;
       try{
           byId = busRouteBusDetailRepository.getById(id);
           busRouteBusDetailRepository.deleteById(id);
        return byId;
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println(e);
       }

       return null;
     }

     //////////////////////////////////////////////////////////////////////////

    //  public BusRouteBusDetail getSourceDetail(BusRouteBusDetail busRouteBusDetail){


    //  }
}
