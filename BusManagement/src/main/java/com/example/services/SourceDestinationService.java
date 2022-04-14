package com.example.services;

import java.util.List;

import com.example.dao.SourceDestinationRepository;
import com.example.entites.SourceDestination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SourceDestinationService {
    
    @Autowired
    private SourceDestinationRepository sourceDestinationRepository;

    public SourceDestination getSource(){

        SourceDestination list =sourceDestinationRepository.getSource();
        return list;
    }
}
