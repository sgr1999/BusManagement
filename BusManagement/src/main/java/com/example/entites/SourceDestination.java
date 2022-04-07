package com.example.entites;

import javax.persistence.*;

@Entity
public class SourceDestination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sourceDestinationId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private State stateId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private District districtId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private City cityCode;

	

	public long getSourceDestinationId() {
		return sourceDestinationId;
	}

	public void setSourceDestinationId(long sourceDestinationId) {
		this.sourceDestinationId = sourceDestinationId;
	}

	public State getStateId() {
		return stateId;
	}

	public void setStateId(State stateId) {
		this.stateId = stateId;
	}

	public District getDistrictId() {
		return districtId;
	}

	public void setDistrictId(District districtId) {
		this.districtId = districtId;
	}

	public City getCityCode() {
		return cityCode;
	}

	public void setCityCode(City cityCode) {
		this.cityCode = cityCode;
	}

	@Override
	public String toString() {
		return "SourceDestination [cityCode=" + cityCode + ", districtId=" + districtId + ", sourceDestinationId="
				+ sourceDestinationId + ", stateId=" + stateId + "]";
	}
	
	
	
}
