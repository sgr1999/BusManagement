package com.example.dao;

import java.util.List;

import com.example.Model.SourceDestinationModel;
import com.example.entites.City;
import com.example.entites.SourceDestination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface SourceDestinationRepository extends JpaRepository<SourceDestination, Long>{

    @Query("select sd.cityId from SourceDestination sd where sd.cityId = :id")
    public City getCityId(@Param("id") City city);
}
