package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class BusScheduleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busScheDetailsId;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BusSchedule> schedule = new ArrayList<>();

	

	


	
	
}
