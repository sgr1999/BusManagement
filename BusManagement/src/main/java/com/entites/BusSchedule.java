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
	

}
