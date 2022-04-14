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

    //Add City Details
    public City addCity(City city){
        
        City save = cityRepository.save(city);
        System.out.println(save);
        return save;
    }

    //Add City Details
    public List<City> getCity(){
        
        List<City> list = cityRepository.getAllCity();
        cityRepository.findAll();
        return list;
    }
}
