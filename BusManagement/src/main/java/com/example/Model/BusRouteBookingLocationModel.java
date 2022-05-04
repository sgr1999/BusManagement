package com.example.Model;

public class BusRouteBookingLocationModel {
    
    private String arrivalTime;
    private String routeSequence;
    private String bookingAllowed;

    private String totalKm;
    private String busDepartureTime;
    private String busArrivalTime;
    private String cityName;


    

    
    public BusRouteBookingLocationModel(String arrivalTime, String routeSequence, String bookingAllowed, String totalKm,
            String busDepartureTime, String busArrivalTime, String cityName) {
        this.arrivalTime = arrivalTime;
        this.routeSequence = routeSequence;
        this.bookingAllowed = bookingAllowed;
        this.totalKm = totalKm;
        this.busDepartureTime = busDepartureTime;
        this.busArrivalTime = busArrivalTime;
        this.cityName = cityName;
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
   
    public String getTotalKm() {
        return totalKm;
    }
    public void setTotalKm(String totalKm) {
        this.totalKm = totalKm;
    }
    public String getBusDepartureTime() {
        return busDepartureTime;
    }
    public void setBusDepartureTime(String busDepartureTime) {
        this.busDepartureTime = busDepartureTime;
    }
    public String getBusArrivalTime() {
        return busArrivalTime;
    }
    public void setBusArrivalTime(String busArrivalTime) {
        this.busArrivalTime = busArrivalTime;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }




}
