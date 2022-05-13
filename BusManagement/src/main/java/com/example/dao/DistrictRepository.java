package com.example.dao;

import java.util.*;

import com.example.Model.DistrictModel;
import com.example.entites.District;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistrictRepository extends JpaRepository<District,Long>{

    @Query("select s.districtCode from District s where s.districtCode = :code")
    public Long getDistrictCode(@Param("code") Long code);

    @Query("select s.districtName from District s where s.districtName = :name")
    public String getDistrictName(@Param("name") String name);
}
