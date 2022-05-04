package com.example.Model;

public class CityModel {
    
    private Long cityCode;
    private String cityName;
    public CityModel(Long cityCode, String cityName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
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
    @Override
    public String toString() {
        return "CityModel [cityCode=" + cityCode + ", cityName=" + cityName + "]";
    }
    

    
   
}
