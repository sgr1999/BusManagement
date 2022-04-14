package com.example.dao;

import com.example.entites.SourceDestination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SourceDestinationRepository extends JpaRepository<SourceDestination, Long>{
    
    @Query("select s from SourceDestination s")
    public SourceDestination getSource();
}
