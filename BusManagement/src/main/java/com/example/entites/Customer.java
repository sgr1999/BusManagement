package com.example.entites;

import javax.persistence.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private int age;
	private String gender;
	private String mobile;


	
	

}
