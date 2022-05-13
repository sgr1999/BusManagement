package com.example.Model;

public class CityModel {
    
    private Long id;
    private Long cityCode;
    private String cityName;
  
    
    public CityModel(Long id, Long cityCode, String cityName) {
        this.id = id;
        this.cityCode = cityCode;
        this.cityName = cityName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
