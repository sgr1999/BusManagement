package com.example.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class City extends Auditable<String>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private Long cityId;

    @NotNull(message = "city code can not be null")
    @Column(name = "city_code", unique = true)
    private Long cityCode;

    @NotBlank(message = "city name is required")
    @Column(name = "city_name" ,unique = true)
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private District districtId;



    

    public City() {
    }

    public City(Long cityId, @NotNull(message = "city code can not be null") Long cityCode,
            @NotBlank(message = "city name is required") String cityName, District districtId) {
        this.cityId = cityId;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.districtId = districtId;
    }

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
