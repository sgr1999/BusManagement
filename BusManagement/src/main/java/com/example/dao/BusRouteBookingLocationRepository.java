package com.example.dao;


import com.example.entites.BusRouteBookingLocation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRouteBookingLocationRepository extends JpaRepository<BusRouteBookingLocation,Long>{
    

    // @Query("select new com.example.Model.BusRouteBookingLocationModel(brb.arrivalTime, brb.routeSequence, brb.bookingAllowed, bdr.source, bdr.destination, bdr.totalKm , bdr.busDepartureTime , bdr.busArrivalTime,bd.busDepoName, bd.busDepoAddress, c.cityName, d.districtName, s.stateName) from BusRouteBookingLocation brb, BusDepoRoute bdr, BusDepo bd, City c, District d, State s")
    // public List<BusRouteBookingLocationModel> findData();
}
