package com.example.dao;

import java.util.*;

import com.example.Model.DistrictModel;
import com.example.entites.District;
import com.example.entites.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistrictRepository extends JpaRepository<District,Long>{

    @Query("select d from District d")
    public List<District> getAll();

    @Query("select new com.example.Model.DistrictModel(d.districtCode, d.districtName, s.stateCode, s.stateName) from District d, State s")
    public List<DistrictModel> getData();

    @Query("select new com.example.Model.DistrictModel(d.districtCode, d.districtName, s.stateCode, s.stateName) from District d, State s where d.districtId = :id")
    public DistrictModel getDataById(@Param("id") Long id);
}
