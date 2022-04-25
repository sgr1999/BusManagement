package com.example.selectedData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dao.DistrictRepository;
import com.example.entites.District;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class districtSelected {
    
    @Autowired
    private DistrictRepository districtRepository;

  
    // District d = new District();
    // List<District> list = new ArrayList<>();
    // public List<District> getAll(){

    //     districtRepository.findAll();

    // }
}
