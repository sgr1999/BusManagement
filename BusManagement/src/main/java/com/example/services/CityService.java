package com.example.services;

import com.example.dao.CityRepository;
import com.example.entites.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;

    public City addCity(City city){
        
        City save = cityRepository.save(city);
        System.out.println(save);
        return save;
    }
}
