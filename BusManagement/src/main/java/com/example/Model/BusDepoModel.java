package com.example.Model;

public class BusDepoModel {
    
    private String busDepoName;
    private String busDepoAddress;

    

    public BusDepoModel(String busDepoName, String busDepoAddress) {
        this.busDepoName = busDepoName;
        this.busDepoAddress = busDepoAddress;
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
