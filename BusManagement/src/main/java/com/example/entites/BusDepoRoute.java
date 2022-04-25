package com.example.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "bus_depo_route")
public class BusDepoRoute extends Auditable<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="busdepo_route_id")
	private Long busDepoRouteId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="source_id")
	private SourceDestination sourceId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="distination_id")
	private SourceDestination distinationId;

	@Column(name = "total_km")
	private String totalKm;

	@Column(name = "bus_departure_time")
	private String busDepartureTime;

	@Column(name = "bus_arrival_time")
	private String busArrivalTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "busdepo_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BusDepo busDepoId;

	public Long getBusDepoRouteId() {
		return busDepoRouteId;
	}

	public void setBusDepoRouteId(Long busDepoRouteId) {
		this.busDepoRouteId = busDepoRouteId;
	}


	public SourceDestination getSourceId() {
		return sourceId;
	}

	public void setSourceId(SourceDestination sourceId) {
		this.sourceId = sourceId;
	}

	public SourceDestination getDistinationId() {
		return distinationId;
	}

	public void setDistinationId(SourceDestination distinationId) {
		this.distinationId = distinationId;
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
				+ ", busDepoId=" + busDepoId + ", busDepoRouteId=" + busDepoRouteId + ", distination=" + distinationId
				+ ", source=" + sourceId + ", totalKm=" + totalKm + "]";
	}

	
	
	
	
}
