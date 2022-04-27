package com.example.Model;

public class CityModel {
    
    private Long cityCode;
    private String cityName;
    private Long districtCode;
    private String districtName;
    private String stateCode;
    private String stateName;
    

    
    public CityModel(Long cityCode, String cityName, Long districtCode, String districtName, String stateCode,
            String stateName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.districtCode = districtCode;
        this.districtName = districtName;
        this.stateCode = stateCode;
        this.stateName = stateName;
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
    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
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
        return "CityModel [cityCode=" + cityCode + ", cityName=" + cityName + ", districtCode=" + districtCode
                + ", districtName=" + districtName + ", stateCode=" + stateCode + ", stateName=" + stateName + "]";
    }

    
}
