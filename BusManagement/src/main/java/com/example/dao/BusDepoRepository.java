package com.example.dao;

import java.util.List;

import com.example.Model.BusDepoModel;
import com.example.entites.BusDepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusDepoRepository extends JpaRepository<BusDepo, Long>{
    

    @Query("select new com.example.Model.BusDepoModel(bd.busDepoName, bd.busDepoAddress) from BusDepo bd")
    public List<BusDepoModel> findData();

    @Query("select count(b.busDepoId) from BusDepo b")
    public Long countData();

    @Query("select new com.example.Model.BusDepoModel(bd.busDepoName, bd.busDepoAddress) from BusDepo bd where bd.busDepoId = :id")
    public BusDepoModel findDataById(@Param("id") Long id);

}
