package com.example.entites;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "source_destination")
public class SourceDestination extends Auditable<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "source_destination_id")
	private Long sourceDestinationId;


	@OneToMany(targetEntity=SourceDestination.class,cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")		  
    private List<State> stateId=new ArrayList<>();

	@OneToMany(targetEntity=SourceDestination.class,cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id")		  
    private List<District> districtId = new ArrayList<>();

	@OneToMany(targetEntity=SourceDestination.class,cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")		  
    private List<City> cityId= new ArrayList<>();

	public Long getSourceDestinationId() {
		return sourceDestinationId;
	}

	public void setSourceDestinationId(Long sourceDestinationId) {
		this.sourceDestinationId = sourceDestinationId;
	}

	public List<State> getStateId() {
		return stateId;
	}

	public void setStateId(List<State> stateId) {
		this.stateId = stateId;
	}

	public List<District> getDistrictId() {
		return districtId;
	}

	public void setDistrictId(List<District> districtId) {
		this.districtId = districtId;
	}

	public List<City> getCityId() {
		return cityId;
	}

	public void setCityId(List<City> cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "SourceDestination [cityId=" + cityId + ", districtId=" + districtId + ", sourceDestinationId="
				+ sourceDestinationId + ", stateId=" + stateId + "]";
	}

	
	
}
