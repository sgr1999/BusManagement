package com.example.entites;

import javax.persistence.*;

@Entity
@Table(name = "bus_type")
public class BusType extends Auditable<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bustype_id")
	private Long busTypeId;

	@Column(name = "bus_type")
	private String busType;

	@OneToOne(targetEntity = BusType.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "busdepo_id")
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
