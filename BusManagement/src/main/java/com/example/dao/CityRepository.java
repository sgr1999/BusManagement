package com.example.dao;

import java.util.List;

import com.example.entites.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long>{

    @Query("select c from City c")
    public List<City> getAllCity();
    
    @Query("select c from City c where c.cityName = :city")
    public City findCityName(@Param("city") String city);
}
