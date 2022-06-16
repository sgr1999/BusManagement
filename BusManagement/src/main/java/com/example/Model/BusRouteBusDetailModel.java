package com.example.Model;

public class BusRouteBusDetailModel {
    
    private String source;
    private String destination;
    private String totalKm;
    private String busDepartureTime;
    private String busArrivalTime;

    private String busNumber;
    private Long noOfSeat;
    private String busType;
    
  
    public BusRouteBusDetailModel(String source, String destination, String totalKm, String busDepartureTime,
            String busArrivalTime, String busNumber, Long noOfSeat, String busType) {
        this.source = source;
        this.destination = destination;
        this.totalKm = totalKm;
        this.busDepartureTime = busDepartureTime;
        this.busArrivalTime = busArrivalTime;
        this.busNumber = busNumber;
        this.noOfSeat = noOfSeat;
        this.busType = busType;
    }

    
    public String getBusType() {
        return busType;
    }


    public void setBusType(String busType) {
        this.busType = busType;
    }


    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
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
    public String getBusNumber() {
        return busNumber;
    }
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }
    public Long getNoOfSeat() {
        return noOfSeat;
    }
    public void setNoOfSeat(Long noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    
}
