package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "bus_booking")
public class BusBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bus_booking_id")
	private long busBookingId;

	@OneToMany(targetEntity = BusBooking.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "busdepo_route_id")
	private List<BusDepoRoute> busDepoRouteId = new ArrayList<>();

	@OneToMany(targetEntity = BusBooking.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "busroute_busdetail_id")
	private List<BusRouteBusDetail> busRouteBusDetailId = new ArrayList<>();

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
	@Override
	public String toString() {
		return "BusBooking [avaliableSeat=" + avaliableSeat + ", bookingDate=" + bookingDate + ", bookingNumber="
				+ bookingNumber + ", bookingSeat=" + bookingSeat + ", busBookingId=" + busBookingId
				+ ", busDepoRouteId=" + busDepoRouteId + ", busRouteBusDetailId=" + busRouteBusDetailId + ", totalSeat="
				+ totalSeat + ", travelingDate=" + travelingDate + "]";
	}

	
	

	

}
