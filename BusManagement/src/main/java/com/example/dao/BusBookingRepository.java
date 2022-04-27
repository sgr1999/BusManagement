package com.example.dao;

import java.util.List;

import com.example.Model.BusBookingModel;
import com.example.entites.BusBooking;
import com.example.entites.BusDepoRoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusBookingRepository extends JpaRepository<BusBooking, Long>{
    
    @Query("select b.bookingSeat from BusBooking b")
    public Long findBookingSeats();

    BusBooking findByBusDepoRouteIdAndTravelingDate(BusDepoRoute busDepoRoute, String travelingDate);

    // @Query("select new com.example.Model.BusBookingModel(bb.bookingDate, bb.bookingNumber, bb.totalSeat, bb.bookingSeat, bb.avaliableSeat, bb.travelingDate, bdr.sourceId, bdr.distinationId, bdr.totalKm, bdr.busDepartureTime, bdr.busArrivalTime, bd.busDepoName, bd.busDepoAddress, c.cityName, d.districtName, s.stateName) from BusBooking bb, BusDepoRoute bdr, BusDepo bd, SourceDestination sd, City c, District d, State s")
    // public List<BusBookingModel> getData();

    @Query("select new com.example.Model.BusBookingModel(bb.bookingDate, bb.bookingNumber, bb.totalSeat, bb.bookingSeat, bb.avaliableSeat, bb.travelingDate, bdr.source, bdr.destination, bdr.totalKm, bdr.busDepartureTime, bdr.busArrivalTime, bd.busDepoName, bd.busDepoAddress, c.cityName, d.districtName, s.stateName) from BusBooking bb, BusDepoRoute bdr, BusDepo bd, City c, District d, State s")
    public List<BusBookingModel> findData();
}
