package com.entites;

import javax.persistence.*;

@Entity
public class PickupPoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	private String pickupPointLocation;
	private String pickupTime;

}
