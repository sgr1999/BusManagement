package com.example.dao;

import java.util.List;

import com.example.entites.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long>{

    @Query("select c from City c")
    public List<City> getAllCity();
    
}