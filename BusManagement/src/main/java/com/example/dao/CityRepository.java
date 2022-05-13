package com.example.dao;

import java.util.List;

import com.example.Model.CityModel;
import com.example.entites.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long>{


    
    @Query("select c.cityName from City c where c.cityId = :id")
    public String findCityName(@Param("id") Long id);

    @Query("select s.cityCode from City s where s.cityCode = :code")
    public Long getCityCode(@Param("code") Long code);

    @Query("select s.cityName from City s where s.cityName = :name")
    public String getCityName(@Param("name") String name);

}
