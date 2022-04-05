package com.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BusSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busScheId;
	private String dayOfWeek;
	private String arrivalTime;
	private String destinationTime;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusRoute route;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private SourceDestination destination;

	public int getBusScheId() {
		return busScheId;
	}

	public void setBusScheId(int busScheId) {
		this.busScheId = busScheId;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

	public BusRoute getRoute() {
		return route;
	}

	public void setRoute(BusRoute route) {
		this.route = route;
	}

	public SourceDestination getDestination() {
		return destination;
	}

	public void setDestination(SourceDestination destination) {
		this.destination = destination;
	}
	

	
}
