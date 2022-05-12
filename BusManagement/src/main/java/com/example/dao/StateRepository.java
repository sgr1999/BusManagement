package com.example.dao;


import com.example.entites.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StateRepository extends JpaRepository<State, Long>{
    
    @Query("select s.stateCode from State s where s.stateCode = :code")
    public String getStateCode(@Param("code") String code);

    @Query("select s.stateName from State s where s.stateName = :name")
    public String getStateName(@Param("name") String code);
}
