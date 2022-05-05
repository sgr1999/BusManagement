package com.example.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bus_depo_route")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BusDepoRoute extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "busdepo_route_id")
	private Long busDepoRouteId;

	@Column(name = "source")
	private Long source;

	@Column(name = "destination")
	private Long destination;

	@NotBlank(message = "totalKm can not be empty please enter valid detail")
	@Column(name = "total_km")
	private String totalKm;

	@NotBlank(message = "busDepartureTime can not be empty please enter valid detail")
	@Column(name = "bus_departure_time", unique = true)
	private String busDepartureTime;

	@NotBlank(message = "busArrivalTime can not be empty please enter valid detail")
	@Column(name = "bus_arrival_time", unique = true)
	private String busArrivalTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "busdepo_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonBackReference
	private BusDepo busDepoId;

	public BusDepoRoute(Long busDepoRouteId, Long source, Long destination,
			@NotBlank(message = "totalKm can not be empty please enter valid detail") String totalKm,
			@NotBlank(message = "busDepartureTime can not be empty please enter valid detail") String busDepartureTime,
			@NotBlank(message = "busArrivalTime can not be empty please enter valid detail") String busArrivalTime,
			BusDepo busDepoId) {
		this.busDepoRouteId = busDepoRouteId;
		this.source = source;
		this.destination = destination;
		this.totalKm = totalKm;
		this.busDepartureTime = busDepartureTime;
		this.busArrivalTime = busArrivalTime;
		this.busDepoId = busDepoId;
	}

	public BusDepoRoute() {
	}

	public Long getBusDepoRouteId() {
		return busDepoRouteId;
	}

	public void setBusDepoRouteId(Long busDepoRouteId) {
		this.busDepoRouteId = busDepoRouteId;
	}

	public Long getSource() {
		return source;
	}

	public void setSource(Long source) {
		this.source = source;
	}

	public Long getDestination() {
		return destination;
	}

	public void setDestination(Long destination) {
		this.destination = destination;
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
				+ ", busDepoId=" + busDepoId + ", busDepoRouteId=" + busDepoRouteId + ", destination=" + destination
				+ ", source=" + source + ", totalKm=" + totalKm + "]";
	}

}
