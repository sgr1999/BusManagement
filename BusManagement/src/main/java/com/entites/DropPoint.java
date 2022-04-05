package com.entites;

import javax.persistence.*;

@Entity
public class DropPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	private String dropTime;
	private String stopName;

	
	
}
