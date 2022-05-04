package com.example.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "source_destination")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SourceDestination extends Auditable<String>{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "source_destination_id")
	private Long sourceDestinationId;



	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id") 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private State stateId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private District districtId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id", unique = true) 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
