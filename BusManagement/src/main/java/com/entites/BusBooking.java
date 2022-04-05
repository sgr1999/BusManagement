package com.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class BusBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private int seatNo;
	private int amount;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SourceDestination> sourceDestination = new ArrayList<>();
   
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Customer> customer = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusType busType;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<PickupPoint> pickupPoint = new ArrayList<>();

}
