package com.entites;

import javax.persistence.*;

@Entity
public class SourceDestination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cityName;
	private String cityCode;

	
	
}
