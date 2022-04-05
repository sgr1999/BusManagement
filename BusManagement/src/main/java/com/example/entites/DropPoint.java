package com.example.entites;

import javax.persistence.*;

@Entity
public class DropPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	private String dropTime;
	private String stopName;

	
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getDropTime() {
		return dropTime;
	}
	public void setDropTime(String dropTime) {
		this.dropTime = dropTime;
	}
	public String getStopName() {
		return stopName;
	}
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	
	
}
