package com.example.entites;

import javax.persistence.*;

@Entity
public class BusType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long busTypeId;
	private String busType;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BusDepo busDepoId;

	public long getBusTypeId() {
		return busTypeId;
	}

	public void setBusTypeId(long busTypeId) {
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
