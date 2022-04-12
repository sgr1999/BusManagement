package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;


@Entity
@Table(name = "bus_depo_route")
public class BusDepoRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="busdepo_route_id")
	private Long busDepoRouteId;

	@Column(name="source")
	private String source;

	@Column(name="distination")
	private String distination;

	@Column(name = "total_km")
	private String totalKm;

	@Column(name = "bus_departure_time")
	private String busDepartureTime;

	@Column(name = "bus_arrival_time")
	private String busArrivalTime;

	@ManyToOne(targetEntity = BusDepoRoute.class,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "busdepo_id")
	private BusDepo busDepoId;

	public Long getBusDepoRouteId() {
		return busDepoRouteId;
	}

	public void setBusDepoRouteId(Long busDepoRouteId) {
		this.busDepoRouteId = busDepoRouteId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDistination() {
		return distination;
	}

	public void setDistination(String distination) {
		this.distination = distination;
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

	public BusDepo getBusDepoId() {
		return busDepoId;
	}

	public void setBusDepoId(BusDepo busDepoId) {
		this.busDepoId = busDepoId;
	}

	@Override
	public String toString() {
		return "BusDepoRoute [busArrivalTime=" + busArrivalTime + ", busDepartureTime=" + busDepartureTime
				+ ", busDepoId=" + busDepoId + ", busDepoRouteId=" + busDepoRouteId + ", distination=" + distination
				+ ", source=" + source + ", totalKm=" + totalKm + "]";
	}

	
	
	
	
}
