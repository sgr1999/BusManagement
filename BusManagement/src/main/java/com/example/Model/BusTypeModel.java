package com.example.Model;

public class BusTypeModel {

    private String busType;
    private String busDepoName;
    private String busDepoAddress;
    private String stateName;
    private String districtName;
    private String cityName;

    public BusTypeModel(String busType, String busDepoName, String busDepoAddress, String stateName,
            String districtName, String cityName) {
        this.busType = busType;
        this.busDepoName = busDepoName;
        this.busDepoAddress = busDepoAddress;
        this.stateName = stateName;
        this.districtName = districtName;
        this.cityName = cityName;
    }

    
    public BusTypeModel(String busType, String busDepoName, String busDepoAddress) {
        this.busType = busType;
        this.busDepoName = busDepoName;
        this.busDepoAddress = busDepoAddress;
    }


    public String getBusType() {
        return busType;
    }
    public void setBusType(String busType) {
        this.busType = busType;
    }
    public String getBusDepoName() {
        return busDepoName;
    }
    public void setBusDepoName(String busDepoName) {
        this.busDepoName = busDepoName;
    }
    public String getBusDepoAddress() {
        return busDepoAddress;
    }
    public void setBusDepoAddress(String busDepoAddress) {
        this.busDepoAddress = busDepoAddress;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    
}
