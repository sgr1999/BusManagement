package com.example.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bus_depo")
public class BusDepo extends Auditable<String>{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "busdepo_id")
    private Long busDepoId;

    @Column(name = "busdepo_name")
    private String busDepoName;

    @Column(name = "busdepo_address")
    private String busDepoAddress;

    @OneToOne
	@JoinColumn(name = "state_id",nullable = false)		
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
    private State stateId;

    @OneToOne
    @JoinColumn(name = "district_id",nullable = false)		
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
    private District districtId;

    @OneToOne
	@JoinColumn(name = "city_id", nullable = false)	
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  	
    private City cityId;

    public Long getBusDepoId() {
        return busDepoId;
    }

    public void setBusDepoId(Long busDepoId) {
        this.busDepoId = busDepoId;
    }

    public String getBusDepoName() {
        return busDepoName;
    }

    public void setBusDepoName(String busDepoName) {
        this.busDepoName = busDepoName;
    }

    public String getBusDepoAddress() {
        return busDepoAddress;
    }

    public void setBusDepoAddress(String busDepoAddress) {
        this.busDepoAddress = busDepoAddress;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "BusDepo [busDepoAddress=" + busDepoAddress + ", busDepoId=" + busDepoId + ", busDepoName=" + busDepoName
                + ", cityId=" + cityId + ", districtId=" + districtId + ", stateId=" + stateId + "]";
    }


    
}
