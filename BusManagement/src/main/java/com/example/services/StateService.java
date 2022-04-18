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


    //Add State 
    public State addState(State state)
    {
        try {
            
            State save = stateRepository.save(state);
            System.out.println(save);
        } catch (Exception e) {
            
        }
        return state;
    }

    // Get All State
    public List<State> getState()
    {
      
        List<State> list =null;
        try {
            
            list = stateRepository.getAllState();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

    // Get State By Id
    public State getStateById(Long id)
    {
      
        State list =null;
        try {
            
            list = stateRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

     // Update State By Id
     public State updateStateById(State state,Long id)
     {
       
         State list =null;
         try {
             
             list = stateRepository.getById(id);
             list.setStateCode(state.getStateCode());
             list.setStateName(state.getStateName());
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
         return list;
     }

      // Delete State By Id
    public State deleteStateById(Long id)
    {
      
        State list =null;
        try {
            
            stateRepository.deleteById(id);
            list = stateRepository.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }
}
