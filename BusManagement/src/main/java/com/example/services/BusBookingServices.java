package com.example.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.random.RandomGenerator;

import javax.xml.transform.Source;

import org.apache.catalina.connector.Response;
import org.hibernate.annotations.SourceType;
import org.hibernate.id.UUIDHexGenerator;
import org.hibernate.type.UUIDBinaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import net.bytebuddy.asm.Advice.Local;

import com.example.Model.BusBookingInfo;
import com.example.Model.BusBookingModel;
import com.example.dao.BusBookingDetailRepository;
import com.example.dao.BusBookingRepository;
import com.example.dao.BusDepoRouteRepository;
import com.example.dao.BusDetailRepository;
import com.example.dao.BusRouteBusDetailRepository;
import com.example.dao.CustomerRepository;
import com.example.dao.SourceDestinationRepository;
import com.example.entites.BusBooking;
import com.example.entites.BusBookingDetail;
import com.example.entites.BusDepoRoute;
import com.example.entites.BusRouteBusDetail;
import com.example.entites.Customer;
import com.example.entites.SourceDestination;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;

@Service
public class BusBookingServices {

	private static final String UUIDSerializer = null;

	@Autowired
	private BusBookingRepository busBookingRepository;

	@Autowired
	private BusBookingDetailRepository busBookingDetailRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BusDepoRouteRepository busDepoRouteRepository;

	@Autowired
	private BusDetailRepository busDetailRepository;

	@Autowired
	private BusRouteBusDetailRepository busRouteBusDetailRepository;

	@Autowired
	private SourceDestinationRepository sourceDestinationRepository;


	// Add BusBooking Details
	public ResponseEntity<BusBooking> addBusBooking(Map<String, Object> mpBusBooking, BusBookingDetail detail) throws Exception{

        Long totalSeat= 0L;
		Long bookingCount =1L;

	

		try {
			List<BusBookingDetail> busBookingDetails = new ArrayList<BusBookingDetail>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			//    	BusBooking busBooking = new BusBooking();
			String bookingDate = (String) mpBusBooking.get("bookingDate");
			String bookingNumber = (String) mpBusBooking.get("bookingNumber");
			String travelingDate = (String) mpBusBooking.get("travelingDate");
			Long busDepoRouteId =  Long.parseLong((String)mpBusBooking.get("busDepoRouteId"));
			Long busRouteBusDetailId = Long.parseLong((String) mpBusBooking.get("busRouteBusDetailId"));
			Long customerId= Long.parseLong((String)mpBusBooking.get("customerId"));
            Long paymentAmount = Long.parseLong((String)mpBusBooking.get("paymentAmount"));
            String paymentType = (String) mpBusBooking.get("paymentType");
            String paymentId = detail.getPaymentId();
           

		
		   // Passenger Details Logic
			String passengerName = detail.getPassengerName();
			Long passengerAge = detail.getPassengerAge();
			Long seatNumber = detail.getSeatNumber();
			String transactionId = detail.getTransactionId();


			//    	Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(travelingDate);  
			Optional<Customer> customer = customerRepository.findById(customerId);
			Optional<BusDepoRoute> busDepoRoute = busDepoRouteRepository.findById(busDepoRouteId);
			Optional<BusRouteBusDetail> busRouteBusDetail = busRouteBusDetailRepository.findById(busRouteBusDetailId);
			Date travellingDate = dateFormat.parse(travelingDate);
            DateTimeFormatter paymentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();

			BusBooking busBooking = busBookingRepository.findByBusDepoRouteIdAndTravelingDate(busDepoRoute.get(), travelingDate);
			
			// If Class id not found Exception Logic
			if(customer.isEmpty())
			{
				throw new Exception("Customer Id "+customerId+" Is Not Present Into Customer Table");
			}
			if(busDepoRoute.isEmpty())
			{
				throw new Exception("BusDepoRoute Id "+customerId+" Is Not Present Into BusDepoRoute Table");
			}
			if(busRouteBusDetail.isEmpty())
			{
				throw new Exception("BusRouteBusDetail Id "+busRouteBusDetailId+" Is Not Present Into BusRouteBusDetail Table");
			}
			
			

            // Logic of booking Seats
			Long busBookingId = busBookingRepository.findBookingId(busDepoRouteId);
            bookingCount = busBookingRepository.findBookingSeats(busBookingId);
			totalSeat = busRouteBusDetailRepository.totalSeat(busRouteBusDetailId);

			if(bookingCount==null){
				bookingCount=0L;
			}
            Long bookingSeat = bookingCount+1;
			Long avaliableSeat =totalSeat- bookingSeat;

            
            if(busBooking!=null) {
		
				BusBookingDetail bookingDetail  = new BusBookingDetail();
					
				bookingDetail.setCustomerId(customer.get());
				busBookingDetails.add(bookingDetail);
				bookingDetail.setStatus("Confirm");
				bookingDetail.setBusBooking(busBooking);
                bookingDetail.setPaymentAmount(paymentAmount);
                bookingDetail.setPaymentDate(paymentDate.format(now));
                bookingDetail.setPaymentType(paymentType);
                bookingDetail.setPaymentId(paymentId);
				bookingDetail.setTransactionId(transactionId);

				bookingDetail.setPassengerName(passengerName);
				bookingDetail.setPassengerAge(passengerAge);
				bookingDetail.setSeatNumber(seatNumber);
				//	busBooking.setBusBookingDetails(busBookingDetails);
				
                busBooking.setTotalSeat(totalSeat);
                busBooking.setAvaliableSeat(avaliableSeat);
				
				if(bookingCount <= 40 && seatNumber<=40)
				{
					busBooking.setBookingSeat(bookingSeat);
				}
				else if(seatNumber > 40 && bookingCount != 40){
					throw new Exception("Seats are available only 40 between 1 To 40 Seats Number");
					
				}
				else{
					throw new Exception("Bus Seats are full Try another Bus");
				}
				
					busBookingRepository.save(busBooking);
					busBookingDetailRepository.save(bookingDetail);
				
		

			//	busBookingDetailRepository.save(bookingDetail);

              
               
			}else {
				busBooking = new BusBooking();
				busBooking.setBusDepoRouteId(busDepoRoute.get());
				busBooking.setBusRouteBusDetailId(busRouteBusDetail.get());
                busBooking.setTravelingDate(travelingDate);
                busBooking.setBookingNumber(bookingNumber);
                busBooking.setBookingDate(bookingDate);
				
				BusBookingDetail bookingDetail  = new BusBookingDetail();
				bookingDetail.setStatus("confirmed");
				bookingDetail.setCustomerId(customer.get());
				bookingDetail.setBusBooking(busBooking);
				bookingDetail.setPassengerAge(passengerAge);
				bookingDetail.setPassengerName(passengerName);
				bookingDetail.setSeatNumber(seatNumber);
				bookingDetail.setPaymentAmount(paymentAmount);
				bookingDetail.setPaymentDate(paymentDate.format(now));
                bookingDetail.setPaymentType(paymentType);
                bookingDetail.setPaymentId(paymentId);
				bookingDetail.setTransactionId(transactionId);
				busBookingDetails.add(bookingDetail);

                busBooking.setTotalSeat(totalSeat);
		     	busBooking.setAvaliableSeat(avaliableSeat);
                 busBooking.setBookingSeat(bookingSeat);

			//	busBooking.setBusBookingDetails(busBookingDetails);
				busBookingRepository.save(busBooking);
				busBookingDetailRepository.save(bookingDetail);
				
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		catch (ParseException e) {
			e.printStackTrace();
			
		}

		

		return null;
	}


	// public BusBooking addBusBooking(BusBooking busBooking){

	// 	Long totalSeat= (long) 40;
	// 	Long bookedSeat =null;
	// 	Long bookingCount =0L;
	// 	try {
	// 		bookingCount = busBookingRepository.findBookingSeats();
	// 		Long bookingSeat = busBooking.getBookingSeat();

	// 		bookedSeat  = bookingCount+bookingSeat;

	// 		Long avaliableSeat =totalSeat- bookedSeat; 



	// 		busBooking.setTotalSeat(totalSeat);
	// 		busBooking.setAvaliableSeat(avaliableSeat);

	// 		BusBooking save = busBookingRepository.save(busBooking);
	// 		busBooking.setBookingSeat(bookedSeat);
	// 		System.out.println(save);

	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 		System.out.println(e);
	// 	}
	// 	return busBooking;
	// }


	// Get All BusBooking
	public List<BusBookingModel> getBusBooking()
	{

		List<BusBooking> list =null;
		List<BusBookingModel> list1 = new ArrayList<>();

		
		try {

			
		
			list = busBookingRepository.findAll();


				list.forEach(e->{
					SourceDestination source = sourceDestinationRepository.getById(e.getBusDepoRouteId().getSource());
					SourceDestination destination = sourceDestinationRepository.getById(e.getBusDepoRouteId().getDestination());
					list1.add(new BusBookingModel(e.getBookingDate(), e.getBookingNumber(),e.getTotalSeat(),e.getBookingSeat(),e.getAvaliableSeat(), e.getTravelingDate(), source.getCityId().getCityName(), destination.getCityId().getCityName(), e.getBusDepoRouteId().getTotalKm(), e.getBusDepoRouteId().getBusDepartureTime(), e.getBusDepoRouteId().getBusArrivalTime(),e.getBusDepoRouteId().getBusDepoId().getBusDepoName(),e.getBusDepoRouteId().getBusDepoId().getBusDepoAddress()));

				});

			return list1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}


	// Get BusBooking By Id
	public Map<String, Object> getBusBookingById(Long id)
	{

		BusBooking list =null;
		Map<String, Object> map = new HashMap<>();
		try {

			list = busBookingRepository.getById(id);

			SourceDestination source = sourceDestinationRepository.getById(list.getBusDepoRouteId().getSource());
			SourceDestination destination = sourceDestinationRepository.getById(list.getBusDepoRouteId().getDestination());
				map.put("bookingDate", list.getBookingDate());
				map.put("bookingNumber", list.getBookingNumber());
				map.put("totalSeat", list.getTotalSeat());
				map.put("bookingSeat", list.getBookingSeat());
				map.put("avaliableSeat", list.getAvaliableSeat());
				
				map.put("travelingDate", list.getTravelingDate());
				map.put("source", source.getCityId().getCityName());
				map.put("destination", destination.getCityId().getCityName());
				map.put("totalKm", list.getBusDepoRouteId().getTotalKm());
				map.put("busDepartureTime", list.getBusDepoRouteId().getBusDepartureTime());
				map.put("busArrivalTime", list.getBusDepoRouteId().getBusArrivalTime());
				map.put("busDepoName", list.getBusDepoRouteId().getBusDepoId().getBusDepoName());
				map.put("busDepoAddress", list.getBusDepoRouteId().getBusDepoId().getBusDepoAddress());

				return map;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}

	// Update BusBooking By Id
	public BusBooking updateBusBookingById(BusBooking bus,Long id)
	{

		BusBooking list =null;
		try {
			list = busBookingRepository.getById(id);  
			list.setBusDepoRouteId(bus.getBusDepoRouteId());
			list.setBusRouteBusDetailId(bus.getBusRouteBusDetailId());
			list.setBookingNumber(bus.getBookingNumber());
			list.setTravelingDate(bus.getTravelingDate());
			list.setBookingDate(bus.getBookingDate());

			busBookingRepository.save(list);

			return list;
		} 
		catch(TransactionSystemException e1){
			System.out.println("please fill data properly all it can not be null");
		}
		catch(DataIntegrityViolationException ee){
			System.out.println("Check busDepoRouteId OR busRouteBusDetailId that may be not found in database");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}

	//Delete BusBooking By Id
	public BusBooking deleteBusBookingById(Long id){

		BusBooking byId = null;
		try{
			byId = busBookingRepository.getById(id);
			busBookingRepository.deleteById(id);
			return byId;
		}
		catch(DataIntegrityViolationException ee){
			System.out.println("You can not delete Bus Booking that data is present in bus booking details table");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}

		return null;
	}
}