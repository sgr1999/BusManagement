package com.entites;

import javax.persistence.*;


@Entity
public class BusScheduleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busScheDetailsId;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusSchedule schedule;


	
}
