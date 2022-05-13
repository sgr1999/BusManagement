package com.example.Model;


public class DistrictModel {
    
    private Long id;
    private Long districtCode;

    private String districtName;



    




    public DistrictModel(Long districtCode, String districtName) {
        this.districtCode = districtCode;
        this.districtName = districtName;
    }

    

    public DistrictModel(Long id, Long districtCode, String districtName) {
        this.id = id;
        this.districtCode = districtCode;
        this.districtName = districtName;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
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



   




 


}
