package com.example.entites;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "District")
public class District extends Auditable<String>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_id")
    private Long districtId;

    @NotNull(message = "district code can not be null")
    @Column(name = "district_code" , unique = true)
    private Long districtCode;

    @NotBlank(message = "district name is required")
    @Size(min=2, message = "district name should have at least 2 characters")
    @Column(name = "district_name" , unique = true)
    private String districtName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
        return "District [districtCode=" + districtCode 
        + ", districtId = " + districtId 
        + ", districtName = "+ districtName 
        + ", stateId=" + stateId + "]";
    }

    

    
}
