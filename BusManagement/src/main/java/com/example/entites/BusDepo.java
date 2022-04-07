package com.example.entites;

import javax.persistence.*;

@Entity
public class BusDepo {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long busDepoId;
    private String busDepoName;
    private String busDepoAddress;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private State stateId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private District districtId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private City cityId;

    public long getBusDepoId() {
        return busDepoId;
    }

    public void setBusDepoId(long busDepoId) {
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
