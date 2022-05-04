package com.example.dao;

import java.util.List;

import com.example.Model.SourceDestinationModel;
import com.example.entites.SourceDestination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface SourceDestinationRepository extends JpaRepository<SourceDestination, Long>{
    
    @Query("select new com.example.Model.SourceDestinationModel(c.cityCode, c.cityName, d.districtCode, d.districtName, s.stateCode, s.stateName) from City c , District d, State s ")
    public List<SourceDestinationModel> findData();

    @Query("select new com.example.Model.SourceDestinationModel(c.cityCode, c.cityName, d.districtCode, d.districtName, s.stateCode, s.stateName) from SourceDestination sd, City c , District d, State s where sd.sourceDestinationId = :id")
    public SourceDestinationModel findDataById(@Param("id") Long id);

    @Query("select sd.cityId from SourceDestination sd where sd.sourceDestinationId = :id")
    public Long findSource(@Param("id") Long id);
}
