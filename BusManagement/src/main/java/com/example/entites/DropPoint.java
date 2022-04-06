package com.example.entites;

import javax.persistence.*;

@Entity
public class DropPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String dropTime;
	private String stopName;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusMaster busMaster;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BusMaster getBusMaster() {
		return busMaster;
	}

	public void setBusMaster(BusMaster busMaster) {
		this.busMaster = busMaster;
	}

	@Override
	public String toString() {
		return "DropPoint [busMaster=" + busMaster + ", dropTime=" + dropTime + ", id=" + id + ", stopName=" + stopName
				+ "]";
	}
	

	
	
}
