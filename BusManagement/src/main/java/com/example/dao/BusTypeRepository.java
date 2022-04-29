package com.example.dao;

import java.util.List;

import com.example.Model.BusTypeModel;
import com.example.entites.BusType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusTypeRepository extends JpaRepository<BusType,Long>{
    

    @Query("select new com.example.Model.BusTypeModel(bt.busType, bd.busDepoName, bd.busDepoAddress, c.cityName, d.districtName, s.stateName) from BusType bt, BusDepo bd, City c, District d, State s")
    public List<BusTypeModel> findData();
}
