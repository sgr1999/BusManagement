package com.example.services;

import java.util.List;

import com.example.dao.DistrictRepository;
import com.example.entites.District;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictService {
    

    @Autowired
    private DistrictRepository districtRepository;


    public District addDistrict(District dis)
    {
       District save = districtRepository.save(dis);
        System.out.println(save);
        return save;
    }

    public List<District> getDistrict()
    {
      
        List<District> list = districtRepository.getAll();
        
        return list;
    }
}
