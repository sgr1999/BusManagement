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
@Table(name = "bus_type")
public class BusType extends Auditable<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bustype_id")
	private Long busTypeId;

	@Column(name = "bus_type")
	private String busType;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "busdepo_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BusDepo busDepoId;

	public Long getBusTypeId() {
		return busTypeId;
	}

	public void setBusTypeId(Long busTypeId) {
		this.busTypeId = busTypeId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}


	

	public BusDepo getBusDepoId() {
		return busDepoId;
	}

	public void setBusDepoId(BusDepo busDepoId) {
		this.busDepoId = busDepoId;
	}

	@Override
	public String toString() {
		return "BusType [busDepoId=" + busDepoId + ", busType=" + busType + ", busTypeId=" + busTypeId + "]";
	}

	
	
}
