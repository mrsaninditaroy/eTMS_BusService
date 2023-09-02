package com.details.bookings.service.impl;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.details.bookings.dto.BookingsDto;
import com.details.bookings.dto.InventoryDto;
import com.details.bookings.entities.Booking;

import com.details.bookings.repositories.BookingsRepository;
import com.details.bookings.repositories.PassengerRepository;

import com.details.bookings.publisher.Publisher;

import com.details.bookings.service.BookingService;

import java.util.List;
import java.util.stream.Collectors;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingsServiceImpl implements BookingService {

	@Autowired
	private BookingsRepository bookingsRepository;
	
	private RestTemplate restTemplate;

	@Override
	public Booking createBooking(Booking booking) {

		return (bookingsRepository.save(booking));
	}

	@Override
	public ResponseEntity<String> deleteBooking(@PathVariable String bookingid) {
		return new ResponseEntity<String>("Booking with bookingid->" + bookingid + " " + "deleted successfully.",
				HttpStatus.OK);
	}

	@Override
	public BookingsDto getAvailableSeatsByBusId(String busid) {
		
		Booking booking = bookingsRepository.findById(busid).get();
		
		ResponseEntity<InventoryDto> responseEntity=  restTemplate.getForEntity("http://localhost:8097/api/v1/getInventory/", InventoryDto.class);
		
		InventoryDto inventoryDto = responseEntity.getBody();
		
		BookingsDto bookingsDto= new BookingsDto(
				booking.getBookingid(),
				booking.getBusid(),
				booking.getBookingdate(),
				booking.getSource(),
				booking.getDestination(),
				booking.getNoOfSeats(),
				booking.getBookingStatus(),
				booking.getInventoryid()
				
				);
		
		int noOfSeatsBookingwisebyACustomer = Integer.valueOf(bookingsDto.getNoOfSeats());
		
		List<String> availableSeats = inventoryDto.getAvailableSeats();
		
		if(availableSeats.size()  > noOfSeatsBookingwisebyACustomer)
		{
		   bookingsDto.setBookingStatus("PENDING");	
		   
		   sendMessageToActiveMQ(bookingsDto.getBookingid());	   
		   
		}
		
		return bookingsDto;
				
	}

	@Override
	public BookingsDto getBookingById(@PathVariable String busid) {
		
		Booking  booking = bookingsRepository.findById(busid).get();
		
		BookingsDto bookingsDto= new BookingsDto(
				booking.getBookingid(),
				booking.getBusid(),
				booking.getBookingdate(),
				booking.getSource(),
				booking.getDestination(),
				booking.getNoOfSeats(),
				booking.getBookingStatus(),
				booking.getInventoryid()
				
				);
		
		return bookingsDto;
		
		
	}
	
	public String sendMessageToActiveMQ(String message)
	{
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin","tcp://localhost:616161");
		
		try {
			
			Connection connection = factory.createConnection();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("InterProcessCommunication");
			
			TextMessage textMessage1= session.createTextMessage("Communication starting...");
			
			MessageProducer producer = session.createProducer(destination);
			
			producer.send(textMessage1);
			
			TextMessage textMessage2 = session.createTextMessage(message);
			
			producer.send(textMessage2);
			
			session.close();
			
			connection.close();
			
			
		}catch(JMSException jmxe)
		{
			jmxe.printStackTrace();
		}
		
		return "Message sent";
		
	}

}
