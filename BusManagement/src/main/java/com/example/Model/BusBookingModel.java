package com.example.Model;

public class BusBookingModel {
    
    private String bookingDate;
    private String bookingNumber;
    private Long totalSeat;
    private Long bookingSeat;
    private Long avaliableSeat;
    private String travelingDate;

     // private String sourceId;
    // private String distinationId;
    // private String totalKm;
    // private String busDepartureTime;
    // private String busArrivalTime;

    // private String busDepoName;
    // private String busDepoAddress;
    // private String cityName;
    // private String districtName;
    // private String stateName;


    public BusBookingModel(String bookingDate, String bookingNumber, Long totalSeat, Long bookingSeat,
            Long avaliableSeat, String travelingDate) {
        this.bookingDate = bookingDate;
        this.bookingNumber = bookingNumber;
        this.totalSeat = totalSeat;
        this.bookingSeat = bookingSeat;
        this.avaliableSeat = avaliableSeat;
        this.travelingDate = travelingDate;
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

   
    
   
}
