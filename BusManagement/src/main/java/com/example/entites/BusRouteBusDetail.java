package com.example.entites;

import javax.persistence.CascadeType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class BusRouteBusDetail {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long busRouteBusDetailId;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "busRouteBusDetail")
    private List<BusDepoRoute> busDepoRouteId = new ArrayList<>();

    

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BusDetail busDetailId;

    @ManyToOne
	private BusBooking busBooking;
}
