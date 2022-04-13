package com.example.entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;
    private Long cityCode;
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District districtId;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
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
