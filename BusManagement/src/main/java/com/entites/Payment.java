package com.entites;

import javax.persistence.*;

@Entity
public class Payment {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int pay_id;
    private String pay_type;
    private String pay_bill_amount;
    private String pay_date;
}
