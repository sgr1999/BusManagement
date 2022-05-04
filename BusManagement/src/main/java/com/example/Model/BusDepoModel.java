package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
