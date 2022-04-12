package com.example.entites;

import javax.persistence.CascadeType;

import java.util.ArrayList;
import java.util.*;

import javax.persistence.*;
import javax.persistence.FetchType;


@Entity
@Table(name = "bus_detail")
public class BusDetail {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bus_detailId")
    private Long busDetailId;

    @Column(name = "bus_number")
    private String busNumber;

    @Column(name = "bus_type")
    private String busType;

    @Column(name = "no_of_seat")
    private Long noOfSeat;

    @Column(name = "status")
    private String status; 
    
    @ManyToOne(targetEntity = BusDetail.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "busdepo_id")
    private BusDepo busDepoId;

    public Long getBusDetailId() {
        return busDetailId;
    }

    public void setBusDetailId(Long busDetailId) {
        this.busDetailId = busDetailId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Long getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(Long noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BusDepo getBusDepoId() {
        return busDepoId;
    }

    public void setBusDepoId(BusDepo busDepoId) {
        this.busDepoId = busDepoId;
    }

    @Override
    public String toString() {
        return "BusDetail [busDepoId=" + busDepoId + ", busDetailId=" + busDetailId + ", busNumber=" + busNumber
                + ", busType=" + busType + ", noOfSeat=" + noOfSeat + ", status=" + status + "]";
    }

    
   
}
