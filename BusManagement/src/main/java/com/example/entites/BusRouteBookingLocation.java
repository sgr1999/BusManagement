package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "busroute_booking_location")
public class BusRouteBookingLocation extends Auditable<String>{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "busroute_booking_location_id")
    private Long BusRouteBookingLocationId;

    @OneToMany(targetEntity = BusRouteBookingLocation.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "busdepo_route_id")
    private List<BusDepoRoute> busDepoRouteId = new ArrayList<>();

    @OneToMany(targetEntity = BusRouteBookingLocation.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private List<City> cityId= new ArrayList<>();

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "route_sequence")
    private String routeSequence;

    @Column(name = "booking_allowed")
    private String bookingAllowed;

    public Long getBusRouteBookingLocationId() {
        return BusRouteBookingLocationId;
    }

    public void setBusRouteBookingLocationId(Long busRouteBookingLocationId) {
        BusRouteBookingLocationId = busRouteBookingLocationId;
    }

    public List<BusDepoRoute> getBusDepoRouteId() {
        return busDepoRouteId;
    }

    public void setBusDepoRouteId(List<BusDepoRoute> busDepoRouteId) {
        this.busDepoRouteId = busDepoRouteId;
    }

    public List<City> getCityId() {
        return cityId;
    }

    public void setCityId(List<City> cityId) {
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
