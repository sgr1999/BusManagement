package com.example.dao;

import java.util.List;

import com.example.Model.BusDepoRouteModel;
import com.example.entites.BusDepoRoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusDepoRouteRepository extends JpaRepository<BusDepoRoute, Long>{
    
   
   @Query("select new com.example.Model.BusDepoRouteModel(bdr.source, bdr.destination, bdr.totalKm , bdr.busDepartureTime , bdr.busArrivalTime,bd.busDepoName, bd.busDepoAddress, c.cityName, d.districtName, s.stateName) from BusDepoRoute bdr, BusDepo bd, City c, District d, State s")
    public List<BusDepoRouteModel> findData();
}
