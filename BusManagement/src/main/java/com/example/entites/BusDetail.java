package com.example.entites;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class BusDetail {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long busDetailId;
    private String busNumber;
    private String busType;
    private long noOfSeat;
    private String status; 
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BusDepo busDepoId;

    public long getBusDetailId() {
        return busDetailId;
    }

    public void setBusDetailId(long busDetailId) {
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

    public long getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(long noOfSeat) {
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
