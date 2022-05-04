package com.example.Model;

public class BusBookingDetailModel {
    
    private String passengerName;
    private Long passengerAge;
    private String transactionId;
    private Long seatNumber;
    private String paymentDate;
    private String paymentId;
    private Long paymentAmount;
    private String paymentType;
    private String status;
    private Long customerId;
    
    public BusBookingDetailModel(String passengerName, Long passengerAge, String transactionId, Long seatNumber,
            String paymentDate, String paymentId, Long paymentAmount, String paymentType, String status,
            Long customerId) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.transactionId = transactionId;
        this.seatNumber = seatNumber;
        this.paymentDate = paymentDate;
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentType = paymentType;
        this.status = status;
        this.customerId = customerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(Long passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Long seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    
}
