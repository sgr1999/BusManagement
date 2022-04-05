package com.example.entites;

import javax.persistence.*;

@Entity
public class PickupPoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	private String pickupPointLocation;
	private String pickupTime;

	
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getPickupPointLocation() {
		return pickupPointLocation;
	}
	public void setPickupPointLocation(String pickupPointLocation) {
		this.pickupPointLocation = pickupPointLocation;
	}
	public String getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}


	
}
