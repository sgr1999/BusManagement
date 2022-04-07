package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class BusRouteBookingLocation {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long BusRouteBookingLocationId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "busRouteBookingLocation")
    private List<BusDepoRoute> busDepoRouteId = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private City cityId;

    private String arrivalTime;
    private String routeSequence;
    private boolean bookingAllowed;

    
    public long getBusRouteBookingLocationId() {
        return BusRouteBookingLocationId;
    }
    public void setBusRouteBookingLocationId(long busRouteBookingLocationId) {
        BusRouteBookingLocationId = busRouteBookingLocationId;
    }
    public List<BusDepoRoute> getBusDepoRouteId() {
        return busDepoRouteId;
    }
    public void setBusDepoRouteId(List<BusDepoRoute> busDepoRouteId) {
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
    public boolean isBookingAllowed() {
        return bookingAllowed;
    }
    public void setBookingAllowed(boolean bookingAllowed) {
        this.bookingAllowed = bookingAllowed;
    }
    @Override
    public String toString() {
        return "BusRouteBookingLocation [BusRouteBookingLocationId=" + BusRouteBookingLocationId + ", arrivalTime="
                + arrivalTime + ", bookingAllowed=" + bookingAllowed + ", busDepoRouteId=" + busDepoRouteId
                + ", cityId=" + cityId + ", routeSequence=" + routeSequence + "]";
    }
    
}
