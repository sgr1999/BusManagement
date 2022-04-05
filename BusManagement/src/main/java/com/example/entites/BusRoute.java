package com.example.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long routeId;
	private String routeName;

	

	
}
