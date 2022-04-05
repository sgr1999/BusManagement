package com.example.entites;

import javax.persistence.*;

@Entity
@Table(name="BUSTYPE")
public class BusType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String busType;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}



}
