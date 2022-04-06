package com.example.entites;

import javax.persistence.*;

@Entity
public class Payment {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long payId;
    private String payType;
    private String payBillAmount;
    private String payDate;

    
  

    
}
