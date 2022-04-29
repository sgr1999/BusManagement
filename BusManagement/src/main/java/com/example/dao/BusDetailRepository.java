package com.example.dao;

import java.util.List;

import com.example.Model.BusDetailModel;
import com.example.entites.BusDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusDetailRepository extends JpaRepository<BusDetail,Long>{
    

    @Query("select new com.example.Model.BusDetailModel(b.busNumber, b.noOfSeat, b.status, bt.busType, bd.busDepoName, bd.busDepoAddress) from BusDetail b, BusType bt, BusDepo bd")
    public List<BusDetailModel> findData();
}
