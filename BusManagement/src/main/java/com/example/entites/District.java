package com.example.entites;

import javax.persistence.*;

@Entity
public class District {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long districtId;
    private long districtCode;
    private String districtName;
    
    public long getDistrictId() {
        return districtId;
    }
    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }
    public long getDistrictCode() {
        return districtCode;
    }
    public void setDistrictCode(long districtCode) {
        this.districtCode = districtCode;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    @Override
    public String toString() {
        return "District [districtCode=" + districtCode + ", districtId=" + districtId + ", districtName="
                + districtName + "]";
    }


    
}
