package com.example.services;

import com.example.dao.BusDepoRepository;
import com.example.entites.BusDepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusDepoService {
    
    @Autowired
    private BusDepoRepository busDepoRepository;

    public BusDepo addBusDepo(BusDepo busDepo){

         
        try {
            
            BusDepo save = busDepoRepository.save(busDepo);
            System.out.println(save);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return busDepo;
    }
}
