package com.example.Model;

import com.example.entites.State;

public class DistrictModel {
    

    private Long districtCode;


    private String districtName;

    private Long stateCode;

    private String stateName;

    public DistrictModel(Long districtCode, String districtName, Long stateCode, String stateName) {
        this.districtCode = districtCode;
        this.districtName = districtName;
        this.stateCode = stateCode;
        this.stateName = stateName;
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

    public Long getStateCode() {
        return stateCode;
    }

    public void setStateCode(Long stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "DistrictModel [districtCode=" + districtCode + ", districtName=" + districtName + ", stateCode="
                + stateCode + ", stateName=" + stateName + "]";
    }






 


}
