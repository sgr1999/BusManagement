package com.example.entites;

import javax.persistence.*;

@Entity
public class BusType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String busType;

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getBusType() {
		return busType;
	}



	public void setBusType(String busType) {
		this.busType = busType;
	}



	@Override
	public String toString() {
		return "BusType [busType=" + busType + ", id=" + id + "]";
	}

	
	
}
