package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class BusBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long busBookingId;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy ="busBooking")
	private List<BusDepoRoute> busDepoRouteId = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy ="busBooking")
	private List<BusRouteBusDetail> busRouteBusDetailId = new ArrayList<>();

	private String bookingDate;
	private String bookingNumber;
	private long totalSeat;
	private long bookingSeat;
	private long avaliableSeat;
	private String travelingDate;

	
	public long getBusBookingId() {
		return busBookingId;
	}
	public void setBusBookingId(long busBookingId) {
		this.busBookingId = busBookingId;
	}
	public List<BusDepoRoute> getBusDepoRouteId() {
		return busDepoRouteId;
	}
	public void setBusDepoRouteId(List<BusDepoRoute> busDepoRouteId) {
		this.busDepoRouteId = busDepoRouteId;
	}
	public List<BusRouteBusDetail> getBusRouteBusDetailId() {
		return busRouteBusDetailId;
	}
	public void setBusRouteBusDetailId(List<BusRouteBusDetail> busRouteBusDetailId) {
		this.busRouteBusDetailId = busRouteBusDetailId;
	}
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
	public long getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(long totalSeat) {
		this.totalSeat = totalSeat;
	}
	public long getBookingSeat() {
		return bookingSeat;
	}
	public void setBookingSeat(long bookingSeat) {
		this.bookingSeat = bookingSeat;
	}
	public long getAvaliableSeat() {
		return avaliableSeat;
	}
	public void setAvaliableSeat(long avaliableSeat) {
		this.avaliableSeat = avaliableSeat;
	}
	public String getTravelingDate() {
		return travelingDate;
	}
	public void setTravelingDate(String travelingDate) {
		this.travelingDate = travelingDate;
	}
	
	@Override
	public String toString() {
		return "BusBooking [avaliableSeat=" + avaliableSeat + ", bookingDate=" + bookingDate + ", bookingNumber="
				+ bookingNumber + ", bookingSeat=" + bookingSeat + ", busBookingId=" + busBookingId
				+ ", busDepoRouteId=" + busDepoRouteId + ", busRouteBusDetailId=" + busRouteBusDetailId + ", totalSeat="
				+ totalSeat + ", travelingDate=" + travelingDate + "]";
	}

	

}
