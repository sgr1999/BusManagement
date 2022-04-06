package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class BusBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	private String seatNo;
	private long amount;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private SourceDestination sourceDestination;
   
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusType busType;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private PickupPoint pickupPoint;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DropPoint dropPoint;

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public SourceDestination getSourceDestination() {
		return sourceDestination;
	}

	public void setSourceDestination(SourceDestination sourceDestination) {
		this.sourceDestination = sourceDestination;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	public PickupPoint getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(PickupPoint pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public DropPoint getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(DropPoint dropPoint) {
		this.dropPoint = dropPoint;
	}

	@Override
	public String toString() {
		return "BusBooking [amount = " + amount 
		+ ",\n bookingId = " + bookingId 
		+ ",\n busType = " + busType 
		+ ",\n customer = "+ customer 
		+ ",\n dropPoint = " + dropPoint 
		+ ",\n pickupPoint = " + pickupPoint 
		+ ",\n seatNo = " + seatNo
		+ ",\n sourceDestination = " + sourceDestination + "]";
	}

	



	


	

}
