package com.example.dao;

import java.util.*;

import com.example.Model.DistrictModel;
import com.example.entites.District;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistrictRepository extends JpaRepository<District,Long>{

    @Query("select d from District d")
    public List<District> getAll();

    @Query("select d.districtCode,d.districtName,d.stateId from District d")
    public List<DistrictModel> getDistrict();
}
