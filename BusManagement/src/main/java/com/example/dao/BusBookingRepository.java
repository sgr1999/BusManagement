package com.example.dao;


import com.example.entites.BusBooking;
import com.example.entites.BusDepoRoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusBookingRepository extends JpaRepository<BusBooking, Long>{
    

    

    @Query("select bb.id from BusBooking bb , BusDepoRoute bdr where bdr.busDepoRouteId = :id")
    public Long findBookingId(@Param("id") Long id);

    @Query("select count(bbd.seatNumber) from BusBooking bb , BusBookingDetail bbd where bb.id = :id")
    public Long findBookingSeats(@Param("id") Long id);

    BusBooking findByBusDepoRouteIdAndTravelingDate(BusDepoRoute busDepoRoute, String travelingDate);


    // @Query("select new com.example.Model.BusBookingModel(bb.bookingDate, bb.bookingNumber, bb.totalSeat, bb.bookingSeat, bb.avaliableSeat, bb.travelingDate, bdr.source, bdr.destination, bdr.totalKm , bdr.busDepartureTime , bdr.busArrivalTime, bd.busDepoName, bd.busDepoAddress, c.cityName, d.districtName, s.stateName) from BusBooking bb, BusDepoRoute bdr, BusDepo bd, City c, District d, State s")
    // public List<BusBookingModel> findData();

  
}
