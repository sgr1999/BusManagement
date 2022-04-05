package com.example.entites;


import javax.persistence.*;

@Entity
public class BusSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long busScheId;
	private String dayOfWeek;
	private String arrivalTime;
	private String destinationTime;

	

	
}
