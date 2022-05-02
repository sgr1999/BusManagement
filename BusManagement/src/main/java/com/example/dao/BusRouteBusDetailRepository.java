package com.example.dao;

import com.example.entites.BusRouteBusDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusRouteBusDetailRepository extends JpaRepository<BusRouteBusDetail,Long>{
    

    @Query("select b.noOfSeat from BusDetail b , BusRouteBusDetail brbd where brbd.busRouteBusDetailId = :id")
    public Long totalSeat(@Param("id") Long id);
}
