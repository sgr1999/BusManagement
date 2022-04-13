package com.example.services;

import java.util.List;

import com.example.dao.StateRepository;
import com.example.entites.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateService {
    
    @Autowired
    private StateRepository stateRepository;


    public State addState(State state)
    {
        State save = stateRepository.save(state);
        System.out.println(save);
        return state;
    }

    public List<State> getState()
    {
      
        List<State> list = stateRepository.getAllState();
        return list;
    }
}
