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



	


	

}
