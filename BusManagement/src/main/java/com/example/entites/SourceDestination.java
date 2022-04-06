package com.example.entites;

import javax.persistence.*;

@Entity
public class SourceDestination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cityName;
	private String cityCode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	@Override
	public String toString() {
		return "SourceDestination [cityCode=" + cityCode + ", cityName=" + cityName + ", id=" + id + "]";
	}

	
	
}
