package com.example.entites;

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
public class BusBookingDetail extends Auditable<String>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bus_booking_detail_id")
    private Long id;

    // here is my problem
//    @OneToMany(targetEntity = BusBookingDetail.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "bus_booking_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private List<BusBooking> busBookingId = new ArrayList<>();

//    @JoinColumn(name = "bus_booking_id")
//   	@JsonIgnore
//   	@ManyToOne(fetch = FetchType.LAZY)
//   	private BusBooking busBooking;
    
    @ManyToOne
    //Adding the name
    @JoinColumn(name = "bus_booking_id")
    BusBooking busBooking;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Customer customerId;

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



//    public List<BusBooking> getBusBookingId() {
//        return busBookingId;
//    }
//
//    public void setBusBookingId(List<BusBooking> busBookingId) {
//        this.busBookingId = busBookingId;
//    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
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

    public BusBooking getBusBooking() {
		return busBooking;
	}

	public void setBusBooking(BusBooking busBooking) {
		this.busBooking = busBooking;
	}

    @Override
    public String toString() {
        return "BusBookingDetail [busBooking=" + busBooking + ", customerId=" + customerId + ", id=" + id
                + ", paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate + ", paymentId=" + paymentId
                + ", paymentType=" + paymentType + ", seatNumber=" + seatNumber + ", status=" + status + "]";
    }


}