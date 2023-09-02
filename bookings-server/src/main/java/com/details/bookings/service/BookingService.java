package com.details.bookings.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.details.bookings.dto.BookingsDto;
import com.details.bookings.entities.Booking;

public interface BookingService {
	
	public Booking createBooking(Booking booking);
	
	public ResponseEntity<String> deleteBooking(@PathVariable String bookingid);
		
	public BookingsDto  getBookingById(String bookingid);	

	public BookingsDto getAvailableSeatsByBusId(String busid);

}
