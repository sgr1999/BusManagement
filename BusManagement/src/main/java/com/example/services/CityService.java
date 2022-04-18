package com.example.services;

import java.util.List;

import com.example.dao.CityRepository;
import com.example.entites.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;

     //Add City 
     public City addCity(City city)
     {
         try {
             
             City save = cityRepository.save(city);
             System.out.println(save);
         } catch (Exception e) {
             
         }
         return city;
     }
 
     // Get All State
     public List<City> getCity()
     {
       
         List<City> list =null;
         try {
             
             list = cityRepository.findAll();
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }
 
     // Get City By Id
     public City getCityById(Long id)
     {
       
         City list =null;
         try {
             
             list = cityRepository.getById(id);
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }
 
      // Update City By Id
      public City updateStateById(City city,Long id)
      {
        
        City list =null;
          try {
              list.setCityCode(city.getCityCode());
              list.setCityName(city.getCityName());

              cityRepository.save(list);
          } catch (Exception e) {
              e.printStackTrace();
              System.out.println(e);
          }
          return list;
      }
 
      //Delete By Id
      public City deleteCityById(Long id){

        City byId = null;
        try{
            cityRepository.deleteById(id);
            byId = cityRepository.getById(id);

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

        return byId;
      }
}
