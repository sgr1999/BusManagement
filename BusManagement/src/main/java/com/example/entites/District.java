package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.example.entites.State;

@Entity
@Table(name = "District")
public class District {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_code")
    private Long districtCode;

    @Column(name = "district_name")
    private String districtName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State stateId;

    
    public Long getDistrictId() {
        return districtId;
    }


    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }


    public Long getDistrictCode() {
        return districtCode;
    }


    public void setDistrictCode(Long districtCode) {
        this.districtCode = districtCode;
    }


    public String getDistrictName() {
        return districtName;
    }


    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }


    public State getStateId() {
        return stateId;
    }


    public void setStateId(State stateId) {
        this.stateId = stateId;
    }


    @Override
    public String toString() {
        return "District [districtCode=" + districtCode + ", districtId=" + districtId + ", districtName="
                + districtName + ", stateId=" + stateId + "]";
    }

    

    
}
