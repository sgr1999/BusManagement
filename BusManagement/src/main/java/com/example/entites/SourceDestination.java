package com.example.entites;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "source_destination")
public class SourceDestination extends Auditable<String>{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "source_destination_id")
	private Long sourceDestinationId;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id" , insertable = false, nullable = true) 
    private State stateId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id" , insertable = false, nullable = true)
    private District districtId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id" , insertable = false, nullable = true) 
    private City cityId;

	public Long getSourceDestinationId() {
		return sourceDestinationId;
	}

	public void setSourceDestinationId(Long sourceDestinationId) {
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

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "SourceDestination [cityId=" + cityId + ", districtId=" + districtId + ", sourceDestinationId="
				+ sourceDestinationId + ", stateId=" + stateId + "]";
	}

	
}
