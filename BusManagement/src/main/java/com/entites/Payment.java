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

    
    public int getPay_id() {
        return pay_id;
    }
    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }
    public String getPay_type() {
        return pay_type;
    }
    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }
    public String getPay_bill_amount() {
        return pay_bill_amount;
    }
    public void setPay_bill_amount(String pay_bill_amount) {
        this.pay_bill_amount = pay_bill_amount;
    }
    public String getPay_date() {
        return pay_date;
    }
    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }


    
}
