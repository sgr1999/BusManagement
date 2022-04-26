package com.example.dao;

import java.util.*;

import com.example.Model.DistrictModel;
import com.example.entites.District;
import com.example.entites.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistrictRepository extends JpaRepository<District,Long>{

    @Query("select d from District d")
    public List<District> getAll();

    @Query("select d.districtCode,d.districtName,d.stateId from District d")
    public List<DistrictModel> getDistrict();

    @Query("select d.stateId from District d")
    public List<DistrictModel> getStateId();

    // @Query("select new com.example.Model.DistrictModel d.districtCode, d.districtName from District d where ")
    // public List<DistrictModel> getData();
}
