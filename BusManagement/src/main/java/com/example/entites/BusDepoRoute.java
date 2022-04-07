package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class BusDepoRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long routeId;
	private String source;
	private String distination;
	private String totalKm;
	private String busDepartureTime;
	private String busArrivalTime;

	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private BusDepo busDepoId;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private BusBooking busBooking;

	@ManyToOne
	private BusRouteBookingLocation busRouteBookingLocation;

	@ManyToMany
	private List<BusRouteBusDetail> busRouteBusDetail = new ArrayList<>();

	
}
