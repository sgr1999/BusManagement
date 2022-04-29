package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "bus_booking_detail")
public class BusBookingDetail extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bus_booking_detail_id")
    private Long id;

    // here is my problem
    // @OneToMany(targetEntity = BusBookingDetail.class,fetch = FetchType.LAZY)
    // @JoinColumn(name = "bus_booking_id")
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    // private List<BusBooking> busBookingId = new ArrayList<>();

    // @JoinColumn(name = "bus_booking_id")
    // @JsonIgnore
    // @ManyToOne(fetch = FetchType.LAZY)
    // private BusBooking busBooking;

    // Adding the name
    @ManyToOne
    // @JsonBackReference
    // @JsonIgnoreProperties(value = {"referenceList",
    // "handler","hibernateLazyInitializer"}, allowSetters = true)
    @JoinColumn(name = "bus_booking_id")
    BusBooking busBooking;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Customer customerId;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "passenger_age")
    private Long passengerAge;
    

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "payment_amount")
    private Long paymentAmount;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "status")
    private String status;


    
    

    public BusBookingDetail(Long id, BusBooking busBooking, Customer customerId, String passengerName,
            Long passengerAge, String seatNumber, String paymentDate, String paymentId, Long paymentAmount,
            String paymentType, String status) {
        this.id = id;
        this.busBooking = busBooking;
        this.customerId = customerId;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.seatNumber = seatNumber;
        this.paymentDate = paymentDate;
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentType = paymentType;
        this.status = status;
    }

    

    public String getTransactionId() {
        return transactionId;
    }



    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }



    public BusBookingDetail() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusBooking getBusBooking() {
        return busBooking;
    }

    public void setBusBooking(BusBooking busBooking) {
        this.busBooking = busBooking;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
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

    
    
}