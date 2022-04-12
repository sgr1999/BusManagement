package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "bus_booking_detail")
public class BusBookingDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bus_booking_detail_id")
    private Long busBookingDetailId;

    @OneToMany(targetEntity = BusBookingDetails.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_booking_id")
    private List<BusBooking> busBookingId = new ArrayList<>();

    @OneToMany(targetEntity = BusBookingDetails.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<Customer> customerId =new ArrayList<>();

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "payment_amount")
    private long paymentAmount;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "status")
    private String status;

    public Long getBusBookingDetailId() {
        return busBookingDetailId;
    }

    public void setBusBookingDetailId(Long busBookingDetailId) {
        this.busBookingDetailId = busBookingDetailId;
    }

    public List<BusBooking> getBusBookingId() {
        return busBookingId;
    }

    public void setBusBookingId(List<BusBooking> busBookingId) {
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
