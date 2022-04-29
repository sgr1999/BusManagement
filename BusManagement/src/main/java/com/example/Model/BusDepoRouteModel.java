package com.example.Model;

public class BusDepoRouteModel {
private String source;
private String destination;
private String totalKm;
private String busDepartureTime;
private String busArrivalTime;

private String busDepoName;
private String busDepoAddress;
private String stateName;
private String districtName;
private String cityName;





public BusDepoRouteModel(String source, String destination, String totalKm, String busDepartureTime,
        String busArrivalTime, String busDepoName, String busDepoAddress, String stateName, String districtName,
        String cityName) {
    this.source = source;
    this.destination = destination;
    this.totalKm = totalKm;
    this.busDepartureTime = busDepartureTime;
    this.busArrivalTime = busArrivalTime;
    this.busDepoName = busDepoName;
    this.busDepoAddress = busDepoAddress;
    this.stateName = stateName;
    this.districtName = districtName;
    this.cityName = cityName;
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
public String getSource() {
return source;
}
public void setSource(String source) {
this.source = source;
}
public String getDestination() {
return destination;
}
public void setDestination(String destination) {
this.destination = destination;
}
public String getTotalKm() {
return totalKm;
}
public void setTotalKm(String totalKm) {
this.totalKm = totalKm;
}
public String getBusDepartureTime() {
return busDepartureTime;
}
public void setBusDepartureTime(String busDepartureTime) {
this.busDepartureTime = busDepartureTime;
}
public String getBusArrivalTime() {
return busArrivalTime;
}
public void setBusArrivalTime(String busArrivalTime) {
this.busArrivalTime = busArrivalTime;
}

}

