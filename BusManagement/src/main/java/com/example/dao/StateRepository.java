package com.example.dao;

import java.util.*;

import com.example.entites.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StateRepository extends JpaRepository<State, Long>{
    
    @Query("select s from State s")
    public List<State> getAllState();

    
}
