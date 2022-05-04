package com.example.Model;

public class BusTypeModel1 {
    
    private String busType;
    private String busDepoName;
    private String busDepoAddress;

    public BusTypeModel1(String busType, String busDepoName, String busDepoAddress) {
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
   
    


}
