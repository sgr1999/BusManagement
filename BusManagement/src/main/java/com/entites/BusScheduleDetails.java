package com.entites;

import javax.persistence.*;


@Entity
public class BusScheduleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busScheDetailsId;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusSchedule schedule;

	

	public int getBusScheDetailsId() {
		return busScheDetailsId;
	}

	public void setBusScheDetailsId(int busScheDetailsId) {
		this.busScheDetailsId = busScheDetailsId;
	}

	public BusSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(BusSchedule schedule) {
		this.schedule = schedule;
	}


	
	
}
