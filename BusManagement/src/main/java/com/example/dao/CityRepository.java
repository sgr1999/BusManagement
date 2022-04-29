package com.example.dao;

import java.util.List;

import com.example.Model.CityModel;
import com.example.entites.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long>{

    @Query("select c from City c")
    public List<City> getAllCity();
    
    @Query("select c.cityName from City c where c.cityId = :id")
    public City findCityName(@Param("id") Long id);

    @Query("select new com.example.Model.CityModel(c.cityCode, c.cityName, d.districtCode, d.districtName, s.stateCode, s.stateName) from City c , District d, State s ")
    public List<CityModel> findData();
}
