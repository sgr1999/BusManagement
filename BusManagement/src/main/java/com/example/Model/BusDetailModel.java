package com.example.Model;

public class BusDetailModel {
    
    private String busNumber;
    private Long noOfSeat;
    private String status; 

    private String busType;

    private String busDepoName;
    private String busDepoAddress;


    
    public BusDetailModel(String busNumber, Long noOfSeat, String status, String busType, String busDepoName,
            String busDepoAddress) {
        this.busNumber = busNumber;
        this.noOfSeat = noOfSeat;
        this.status = status;
        this.busType = busType;
        this.busDepoName = busDepoName;
        this.busDepoAddress = busDepoAddress;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getBusType() {
        return busType;
    }
    public void setBusType(String busType) {
        this.busType = busType;
    }
    public String getBusDepoName() {
        return busDepoName;
    }
    public void setBusDepoName(String busDepoName) {
        this.busDepoName = busDepoName;
    }
    public String getBusDepoAddress() {
        return busDepoAddress;
    }
    public void setBusDepoAddress(String busDepoAddress) {
        this.busDepoAddress = busDepoAddress;
    }

    
}
