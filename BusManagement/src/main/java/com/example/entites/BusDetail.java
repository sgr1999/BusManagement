package com.example.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "bus_detail")
public class BusDetail extends Auditable<String>{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bus_detailId")
    private Long busDetailId;

    @Column(name = "bus_number")
    private String busNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_type_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BusType busTypeId;

    @Column(name = "no_of_seat")
    private Long noOfSeat;

    @Column(name = "status")
    private String status; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "busdepo_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

  
    public BusType getBusTypeId() {
        return busTypeId;
    }

    public void setBusTypeId(BusType busTypeId) {
        this.busTypeId = busTypeId;
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
                + ", busTypeId=" + busTypeId + ", noOfSeat=" + noOfSeat + ", status=" + status + "]";
    }

   
}
