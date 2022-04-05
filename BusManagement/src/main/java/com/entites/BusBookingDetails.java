package com.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class BusBookingDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int busBookingDetailsId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BusBooking> busBooking = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customer = new ArrayList<>();
}
