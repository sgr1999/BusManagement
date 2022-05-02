package com.example.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.dao.StateRepository;
import com.example.entites.State;

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
        try {
            
           save = stateRepository.save(state);
           
        }
        catch(DataIntegrityViolationException e1){
            System.out.println("State Code or State Name check properly data alredy does exist in database");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return save;
    }

    // Get All State
    public List<State> getState()
    {
      
        List<State> list =null;
        try {
            
            list = stateRepository.findAll();
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
            return list;
        } 
        catch(EntityNotFoundException e1){
            System.out.println("State id not found in database");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

     // Update State By Id
     public State updateStateById(State state,Long id)
     {
       
         State list =null;
         try {
             
             list = stateRepository.getById(id);
             list.setStateCode(state.getStateCode());
             list.setStateName(state.getStateName());

             stateRepository.save(list);
         } 
         catch(EntityNotFoundException e){
             System.out.println("State Id not present in database");
         }
         catch (Exception e) {
             e.printStackTrace();
             System.out.println(e);
         }
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
