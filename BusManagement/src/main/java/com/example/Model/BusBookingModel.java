package com.example.Model;

public class BusBookingModel {

    private String bookingDate;
    private String bookingNumber;
    private Long totalSeat;
    private Long bookingSeat; 
    private Long avaliableSeat;
    private String travelingDate;

    private String source;
    private String destination;
    private String totalKm;
    private String busDepartureTime;
    private String busArrivalTime;

    private String busDepoName;
    private String busDepoAddress;

    
    public BusBookingModel(String bookingDate, String bookingNumber, Long totalSeat, Long bookingSeat,
            Long avaliableSeat, String travelingDate, String source, String destination, String totalKm,
            String busDepartureTime, String busArrivalTime, String busDepoName, String busDepoAddress) {
        this.bookingDate = bookingDate;
        this.bookingNumber = bookingNumber;
        this.totalSeat = totalSeat;
        this.bookingSeat = bookingSeat;
        this.avaliableSeat = avaliableSeat;
        this.travelingDate = travelingDate;
        this.source = source;
        this.destination = destination;
        this.totalKm = totalKm;
        this.busDepartureTime = busDepartureTime;
        this.busArrivalTime = busArrivalTime;
        this.busDepoName = busDepoName;
        this.busDepoAddress = busDepoAddress;
    }


    public String getBookingDate() {
        return bookingDate;
    }


    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }


    public String getBookingNumber() {
        return bookingNumber;
    }


    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }


    public Long getTotalSeat() {
        return totalSeat;
    }


    public void setTotalSeat(Long totalSeat) {
        this.totalSeat = totalSeat;
    }


    public Long getBookingSeat() {
        return bookingSeat;
    }


    public void setBookingSeat(Long bookingSeat) {
        this.bookingSeat = bookingSeat;
    }


    public Long getAvaliableSeat() {
        return avaliableSeat;
    }


    public void setAvaliableSeat(Long avaliableSeat) {
        this.avaliableSeat = avaliableSeat;
    }


    public String getTravelingDate() {
        return travelingDate;
    }


    public void setTravelingDate(String travelingDate) {
        this.travelingDate = travelingDate;
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
