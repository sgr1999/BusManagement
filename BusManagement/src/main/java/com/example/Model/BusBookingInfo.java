package com.example.Model;

import java.util.List;

public class BusBookingInfo {

    private List<String> passengerName;
    private List<Long> passengerAge;
    private Long noOfSeat;
    private String transactionId;

    
    public BusBookingInfo(List<String> passengerName, List<Long> passengerAge, Long noOfSeat, String transactionId) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.noOfSeat = noOfSeat;
        this.transactionId = transactionId;
    }


    public List<String> getPassengerName() {
        return passengerName;
    }


    public void setPassengerName(List<String> passengerName) {
        this.passengerName = passengerName;
    }


    public List<Long> getPassengerAge() {
        return passengerAge;
    }


    public void setPassengerAge(List<Long> passengerAge) {
        this.passengerAge = passengerAge;
    }


    public Long getNoOfSeat() {
        return noOfSeat;
    }


    public void setNoOfSeat(Long noOfSeat) {
        this.noOfSeat = noOfSeat;
    }


    public String getTransactionId() {
        return transactionId;
    }


    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    

    
}
