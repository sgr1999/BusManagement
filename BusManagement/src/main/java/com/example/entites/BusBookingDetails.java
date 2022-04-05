package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class BusBookingDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long busBookingDetailsId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BusBooking busBooking;

    


    
}
