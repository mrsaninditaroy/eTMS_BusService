package com.details.bookings.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.List;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.details.bookings.entities.Booking;
import com.details.bookings.entities.PassengerDetails;
import com.details.bookings.repositories.BookingsRepository;
import com.details.bookings.repositories.PassengerRepository;
import com.details.bookings.service.BookingService;

public class Consumer {
	
	@Autowired
	BookingsRepository bookingsRepository;
	
	@Autowired
	BookingService bookingsService;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	public Consumer()
	{
		
	}
	
	public String publishMessagetoQueue(String message) {

		ConnectionFactory factory = new ActiveMQConnectionFactory("amin", "admin", "tcp://localhost:61616");

		try {

			Connection connection = factory.createConnection();

			connection.start();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue("InterProcessCommunication");

			MessageConsumer consumer = session.createConsumer(destination);

			consumer.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message message) {
					
					TextMessage textMmessage = (TextMessage)message;
					try {
						String availableSeats = textMmessage.getText();
						
						Object obj = availableSeats;
						
						List<String> availableS  = (List<String>)obj;
						
						int totalAvailableSeats = availableS.size();
						
						List<Booking> listOfBookings = bookingsRepository.findAll();
						
						System.out.println("For each booking...");
						
						for(Booking booking : listOfBookings)
						{
							String busid = booking.getBusid();
							
							System.out.println("busid->"+ busid);
						
						    String noOfSeats = bookingsService.getAvailableSeatsByBusId(busid).getNoOfSeats();
						    
						   int seatsRemaining =  totalAvailableSeats - Integer.valueOf(totalAvailableSeats);
						   
						   System.out.println("seatsRemaining" + seatsRemaining);
						   
						  String bookingid = booking.getBookingid();
						  
						  System.out.println("bookingid->" + bookingid);
						  
						 PassengerDetails passengerDetails =  passengerRepository.findById(bookingid).get();
						 
						 System.out.println("passengerDetails->" + passengerDetails);
						 
						 System.out.println("passengerID->"+ passengerDetails.getPassengerid());
						 
						 System.out.println("passenger-ticket-ID->"+ passengerDetails.getTicketid());
						
						}						
					} catch (JMSException e) {
						e.printStackTrace();
					}

				}

			});

		} catch (JMSException jmxe) {
			jmxe.printStackTrace();
		}
		
		return "Processing  Done";

	}
}


