package com.example.entites;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "busroute_booking_location")
public class BusRouteBookingLocation extends Auditable<String>{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "busroute_booking_location_id")
    private Long BusRouteBookingLocationId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "busdepo_route_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BusDepoRoute busDepoRouteId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City cityId;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "route_sequence")
    private String routeSequence;

    @Column(name = "booking_allowed")
    private String bookingAllowed;


    
    public BusRouteBookingLocation(Long busRouteBookingLocationId, BusDepoRoute busDepoRouteId, City cityId,
            String arrivalTime, String routeSequence, String bookingAllowed) {
        BusRouteBookingLocationId = busRouteBookingLocationId;
        this.busDepoRouteId = busDepoRouteId;
        this.cityId = cityId;
        this.arrivalTime = arrivalTime;
        this.routeSequence = routeSequence;
        this.bookingAllowed = bookingAllowed;
    }


    
    public BusRouteBookingLocation() {
    }



    public Long getBusRouteBookingLocationId() {
        return BusRouteBookingLocationId;
    }

    public void setBusRouteBookingLocationId(Long busRouteBookingLocationId) {
        BusRouteBookingLocationId = busRouteBookingLocationId;
    }

    
  
    public BusDepoRoute getBusDepoRouteId() {
        return busDepoRouteId;
    }

    public void setBusDepoRouteId(BusDepoRoute busDepoRouteId) {
        this.busDepoRouteId = busDepoRouteId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getRouteSequence() {
        return routeSequence;
    }

    public void setRouteSequence(String routeSequence) {
        this.routeSequence = routeSequence;
    }

    public String getBookingAllowed() {
        return bookingAllowed;
    }

    public void setBookingAllowed(String bookingAllowed) {
        this.bookingAllowed = bookingAllowed;
    }

    @Override
    public String toString() {
        return "BusRouteBookingLocation [BusRouteBookingLocationId=" + BusRouteBookingLocationId + ", arrivalTime="
                + arrivalTime + ", bookingAllowed=" + bookingAllowed + ", busDepoRouteId=" + busDepoRouteId
                + ", cityId=" + cityId + ", routeSequence=" + routeSequence + "]";
    }


   
   
}
