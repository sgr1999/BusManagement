package com.example.entites;

import javax.persistence.*;

@Entity
public class PickupPoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String pickupPointLocation;
	private String pickupTime;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusMaster busMaster;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BusMaster getBusMaster() {
		return busMaster;
	}

	public void setBusMaster(BusMaster busMaster) {
		this.busMaster = busMaster;
	}

	@Override
	public String toString() {
		return "PickupPoint [busMaster=" + busMaster + ", id=" + id + ", pickupPointLocation=" + pickupPointLocation
				+ ", pickupTime=" + pickupTime + "]";
	}


	
	
}
