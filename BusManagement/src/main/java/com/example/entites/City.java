package com.example.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cityId;
    private long cityCode;
    private String cityName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private District districtId;

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getCityCode() {
        return cityCode;
    }

    public void setCityCode(long cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    @Override
    public String toString() {
        return "City [cityCode=" + cityCode + ", cityId=" + cityId + ", cityName=" + cityName + ", districtId="
                + districtId + "]";
    }

    

}
