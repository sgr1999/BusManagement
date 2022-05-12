package com.example.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.dao.StateRepository;
import com.example.entites.State;
import com.example.exception.DataAlreadyPresentExceptionHandling;
import com.example.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class StateService {
    
    @Autowired
    private StateRepository stateRepository;


    //Add State 
    public State addState(State state)
    {
        State save = null;
     
        String code = stateRepository.getStateCode(state.getStateCode());
        String name = stateRepository.getStateName(state.getStateName());

        if (code!=null && name!=null) {
            throw new DataAlreadyPresentExceptionHandling("State", "stateCode and stateName");
        }
        if (code!=null) {
            throw new DataAlreadyPresentExceptionHandling("State", "stateCode", state.getStateCode());
        }

        if (name!=null) {
            throw new DataAlreadyPresentExceptionHandling("State", "stateName", state.getStateName());
        }
           save = stateRepository.save(state);
        
           return save;
       
    }

    // Get All State
    public List<State> getState()
    {
      
        List<State> list =null;
        list = stateRepository.findAll();
        
        if (list.size()<=0) {
            throw new ResourceNotFoundException(); 
        }
        return list;
    }

    // Get State By Id
    public State getStateById(Long id)
    {
      
        State list =null;
            
            list = stateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("state","id",id));
            return list;
        
    }

     // Update State By Id
     public State updateStateById(State state,Long id)
     {
       
         State list =null;
         
             
             list = stateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("State","id",id));
             list.setStateCode(state.getStateCode());
             list.setStateName(state.getStateName());

             stateRepository.save(list);
         return list;
     }

      // Delete State By Id
    public Optional<State> deleteStateById(Long id)
    {
        Optional<State> list=null;
        try {
        list = stateRepository.findById(id);

        if(!list.isEmpty()){

            stateRepository.deleteById(id);
        }else{
            throw new Exception("State Id not present in database");
        }
           
        } 
        catch(EmptyResultDataAccessException e1){
            System.out.println("--state Id does not exist in database--");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }
}
