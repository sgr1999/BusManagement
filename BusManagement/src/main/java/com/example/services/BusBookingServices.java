package com.example.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BusBookingDetailRepository;
import com.example.dao.BusBookingRepository;
import com.example.dao.BusDepoRouteRepository;
import com.example.dao.CustomerRepository;
import com.example.entites.BusBooking;
import com.example.entites.BusBookingDetail;
import com.example.entites.BusDepoRoute;
import com.example.entites.Customer;

@Service
public class BusBookingServices {

	@Autowired
	private BusBookingRepository busBookingRepository;

	@Autowired
	private BusBookingDetailRepository busBookingDetailRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BusDepoRouteRepository busDepoRouteRepository;


	// Add BusBooking Details
	public BusBooking addBusBooking(Map<String, Object> mpBusBooking){

        Long totalSeat= 40L;
		Long bookedSeat =null;
		Long bookingCount =0L;

		try {
			List<BusBookingDetail> busBookingDetails = new ArrayList<BusBookingDetail>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			//    	BusBooking busBooking = new BusBooking();
			String bookingDate = (String) mpBusBooking.get("bookingDate");
			String bookingNumber = (String) mpBusBooking.get("bookingNumber");
			String travelingDate = (String) mpBusBooking.get("travelingDate");
			Long busDepoRouteId =  Long.parseLong((String)mpBusBooking.get("busDepoRouteId"));
			Long customerId= Long.parseLong((String)mpBusBooking.get("customerId"));
			String seatNumber= (String) mpBusBooking.get("seatNumber");
            Long paymentAmount = Long.parseLong((String)mpBusBooking.get("paymentAmount"));
            String paymentType = (String) mpBusBooking.get("paymentType");
            String paymentId = (String) mpBusBooking.get("paymentId");
            String paymentDate = (String) mpBusBooking.get("paymentDate");

			//    	Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(travelingDate);  

			Optional<Customer> customer = customerRepository.findById(customerId);
			Optional<BusDepoRoute> busDepoRoute = busDepoRouteRepository.findById(busDepoRouteId);
			Date travellingDate = dateFormat.parse(travelingDate);
            Date paymentDate1 = dateFormat.parse(paymentDate);
			BusBooking busBooking = busBookingRepository.findByBusDepoRouteIdAndTravelingDate(busDepoRoute.get(), travelingDate);
			

            // Logic of booking Seats
            bookingCount = busBookingRepository.findBookingSeats();
            Long bookingSeat = Long.parseLong((String) mpBusBooking.get("bookingSeat"));
            bookingSeat += bookingCount;
			Long avaliableSeat =totalSeat- bookingSeat;
            
            if(busBooking!=null) {
//				busBookingDetails = busBooking.getBusBookingDetails();
				BusBookingDetail bookingDetail  = new BusBookingDetail();
				bookingDetail.setSeatNumber(seatNumber);
				bookingDetail.setCustomerId(customer.get());
				busBookingDetails.add(bookingDetail);
				bookingDetail.setBusBooking(busBooking);
                bookingDetail.setPaymentAmount(paymentAmount);
                bookingDetail.setPaymentDate(paymentDate);
                bookingDetail.setPaymentType(paymentType);
                bookingDetail.setPaymentId(paymentId);

//				busBooking.setBusBookingDetails(busBookingDetails);

                busBooking.setTotalSeat(totalSeat);
                busBooking.setAvaliableSeat(avaliableSeat);
                busBooking.setBookingSeat(bookingSeat);

				busBookingRepository.save(busBooking);
				busBookingDetailRepository.save(bookingDetail);

              
               
			}else {
				busBooking = new BusBooking();
				busBooking.setBusDepoRouteId(busDepoRoute.get());
                busBooking.setTravelingDate(travelingDate);
                busBooking.setBookingNumber(bookingNumber);
                busBooking.setBookingDate(bookingDate);
				
				BusBookingDetail bookingDetail  = new BusBookingDetail();
				bookingDetail.setSeatNumber(seatNumber);
				bookingDetail.setCustomerId(customer.get());
				bookingDetail.setBusBooking(busBooking);
				busBookingDetails.add(bookingDetail);

                busBooking.setTotalSeat(totalSeat);
		     	busBooking.setAvaliableSeat(avaliableSeat);
                 busBooking.setBookingSeat(bookingSeat);

//				busBooking.setBusBookingDetails(busBookingDetails);
				busBookingRepository.save(busBooking);
				busBookingDetailRepository.save(bookingDetail);
				
			}
			return busBooking;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	public BusBooking addBusBooking(BusBooking busBooking){

		Long totalSeat= (long) 40;
		Long bookedSeat =null;
		Long bookingCount =0L;
		try {
			bookingCount = busBookingRepository.findBookingSeats();
			Long bookingSeat = busBooking.getBookingSeat();

			bookedSeat  = bookingCount+bookingSeat;

			Long avaliableSeat =totalSeat- bookedSeat; 



			busBooking.setTotalSeat(totalSeat);
			busBooking.setAvaliableSeat(avaliableSeat);

			BusBooking save = busBookingRepository.save(busBooking);
			busBooking.setBookingSeat(bookedSeat);
			System.out.println(save);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return busBooking;
	}

	// Get All BusBooking
	public List<BusBooking> getBusBooking()
	{

		List<BusBooking> list =null;
		try {

			list = busBookingRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return list;
	}


	// Get BusBooking By Id
	public BusBooking getBusBookingById(Long id)
	{

		BusBooking list =null;
		try {

			list = busBookingRepository.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return list;
	}

	// Update BusBooking By Id
	public BusBooking updateBusBookingById(BusBooking bus,Long id)
	{

		BusBooking list =null;
		try {
			list = busBookingRepository.getById(id);  
			list.setBusDepoRouteId(bus.getBusDepoRouteId());
			//         list.setBusRouteBusDetailId(bus.getBusRouteBusDetailId());
			list.setBookingNumber(bus.getBookingNumber());
			list.setTotalSeat(bus.getTotalSeat());
			list.setBookingSeat(bus.getBookingSeat());
			list.setAvaliableSeat(bus.getAvaliableSeat());
			list.setTravelingDate(bus.getTravelingDate());

			busBookingRepository.save(list);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return list;
	}

	//Delete BusBooking By Id
	public BusBooking deleteBusBookingById(Long id){

		BusBooking byId = null;
		try{
			byId = busBookingRepository.getById(id);
			busBookingRepository.deleteById(id);

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}

		return byId;
	}
}