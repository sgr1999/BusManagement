package com.example.services;

import com.example.dao.CityRepository;
import com.example.dao.DistrictRepository;
import com.example.dao.StateRepository;
import com.example.entites.City;
import com.example.entites.District;
import com.example.entites.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateDistrictCityService {
    
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public State addState(State state)
    {
        State save = stateRepository.save(state);
        System.out.println(save);
        return state;
    }

    public District addDistrict(District dis)
    {
       District save = districtRepository.save(dis);
        System.out.println(save);
        return save;
    }

    public District getDistrict(District dis)
    {
      
        System.out.println(dis);
        return dis;
    }

    public City addCity(City city)
    {
        City save = cityRepository.save(city);
        System.out.println(save);
        return city;
    }
}
