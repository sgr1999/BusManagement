package com.entites;

import javax.persistence.*;

@Entity
public class SourceDestination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String source;
	private String destination;
	private String distance;
}
