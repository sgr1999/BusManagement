package com.example.entites;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "bus_depo")
public class BusDepo {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "busdepo_id")
    private Long busDepoId;

    @Column(name = "busdepo_name")
    private String busDepoName;

    @Column(name = "busdepo_address")
    private String busDepoAddress;

    @OneToOne(targetEntity=BusDepo.class,cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")		  
    private State stateId;

    @OneToOne(targetEntity=BusDepo.class,cascade = CascadeType.ALL, 
    fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")		  
    private District districtId;

    @OneToOne(targetEntity=BusDepo.class,cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")		  
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
