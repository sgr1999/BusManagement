package com.example.entites;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "bus_booking")
public class BusBooking extends Auditable<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bus_booking_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "busdepo_route_id")
	private BusDepoRoute busDepoRouteId;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "busroute_busdetail_id")
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	private BusRouteBusDetail busRouteBusDetailId;

//	@OneToMany(mappedBy = "busBooking")
//	private List<BusBookingDetail> busBookingDetails;
	
	 @OneToMany(cascade = CascadeType.ALL)
	 private Set<BusBookingDetail> busBookingDetails;
	
	@Column(name = "booking_date")
	private String bookingDate;

	@Column(name = "booking_number")
	private String bookingNumber;

	@Column(name = "total_seat")
	private Long totalSeat;

	@Column(name = "booking_seat")
	private Long bookingSeat;

	@Column(name = "avaliable_seat")
	private Long avaliableSeat;

	@Column(name = "traveling_date")
	private String travelingDate;

	
	public BusDepoRoute getBusDepoRouteId() {
		return busDepoRouteId;
	}
	public void setBusDepoRouteId(BusDepoRoute busDepoRouteId) {
		this.busDepoRouteId = busDepoRouteId;
	}


//	public BusRouteBusDetail getBusRouteBusDetailId() {
//		return busRouteBusDetailId;
//	}
//	public void setBusRouteBusDetailId(BusRouteBusDetail busRouteBusDetailId) {
//		this.busRouteBusDetailId = busRouteBusDetailId;
//	}


	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	public Long getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(Long totalSeat) {
		this.totalSeat = totalSeat;
	}
	public Long getBookingSeat() {
		return bookingSeat;
	}
	public void setBookingSeat(Long bookingSeat) {
		this.bookingSeat = bookingSeat;
	}
	public Long getAvaliableSeat() {
		return avaliableSeat;
	}
	public void setAvaliableSeat(Long avaliableSeat) {
		this.avaliableSeat = avaliableSeat;
	}
	public String getTravelingDate() {
		return travelingDate;
	}
	public void setTravelingDate(String travelingDate) {
		this.travelingDate = travelingDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<BusBookingDetail> getBusBookingDetails() {
		return busBookingDetails;
	}
	public void setBusBookingDetails(Set<BusBookingDetail> busBookingDetails) {
		this.busBookingDetails = busBookingDetails;
	}
	
	
	//	public List<BusBookingDetail> getBusBookingDetails() {
		//		return busBookingDetails;
		//	}
		//	public void setBusBookingDetails(List<BusBookingDetail> busBookingDetails) {
			//		this.busBookingDetails = busBookingDetails;
			//	}
			
			@Override
			public String toString() {
				return "BusBooking [avaliableSeat=" + avaliableSeat + ", bookingDate=" + bookingDate + ", bookingNumber="
						+ bookingNumber + ", bookingSeat=" + bookingSeat + ", busBookingDetails=" + busBookingDetails
						+ ", busDepoRouteId=" + busDepoRouteId + ", id=" + id + ", totalSeat=" + totalSeat + ", travelingDate="
						+ travelingDate + "]";
			}

}