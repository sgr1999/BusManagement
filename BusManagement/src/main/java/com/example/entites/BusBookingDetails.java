package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class BusBookingDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long busBookingDetailId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BusBooking busBookingId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "customer")
    private List<Customer> customerId =new ArrayList<>();

    private String seatNumber;
    private String paymentDate;

    private String paymentId;
    private long paymentAmount;
    private String paymentType;
    private String status;
    
    public long getBusBookingDetailId() {
        return busBookingDetailId;
    }
    public void setBusBookingDetailId(long busBookingDetailId) {
        this.busBookingDetailId = busBookingDetailId;
    }
    public BusBooking getBusBookingId() {
        return busBookingId;
    }
    public void setBusBookingId(BusBooking busBookingId) {
        this.busBookingId = busBookingId;
    }
    public List<Customer> getCustomerId() {
        return customerId;
    }
    public void setCustomerId(List<Customer> customerId) {
        this.customerId = customerId;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
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
    public long getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(long paymentAmount) {
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
    
    @Override
    public String toString() {
        return "BusBookingDetails [busBookingDetailId=" + busBookingDetailId + ", busBookingId=" + busBookingId
                + ", customerId=" + customerId + ", paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate
                + ", paymentId=" + paymentId + ", paymentType=" + paymentType + ", seatNumber=" + seatNumber
                + ", status=" + status + "]";
    }

    
    
}
