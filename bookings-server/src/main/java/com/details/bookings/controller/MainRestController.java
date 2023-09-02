package com.details.bookings.controller;

import com.details.bookings.entities.Booking;
import com.details.bookings.entities.PassengerDetails;
import com.details.bookings.service.BookingService;
import com.details.bookings.service.PassengerService;


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class MainRestController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private PassengerService passengerService;	

	@PostMapping("createBooking")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

		Booking savedBooking = bookingService.createBooking(booking);

		return new ResponseEntity<Booking>(savedBooking, HttpStatus.CREATED);
	}	
	
	@DeleteMapping("/bookings/{bookingid}/deleteBooking")
	public ResponseEntity<String> deleteBooking(@PathVariable("bookingid") String bookingid) {
		
		return  new ResponseEntity<String>("Booking with bookingid->"+bookingid +" "+ "deleted successfully.",HttpStatus.OK);
	
	}
	
	@PostMapping("createPassenger")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PassengerDetails> createPassenger(@RequestBody PassengerDetails passenger) {

	PassengerDetails savedPassenger = passengerService.createPassenger(passenger);

		return new ResponseEntity<PassengerDetails>(savedPassenger, HttpStatus.CREATED);
	}	
	
	@DeleteMapping("/passengers/{passengerid}/deletePpassenger")
	public ResponseEntity<String> deletePassenger(@PathVariable("passengerid") String passengerid) {
		
		return  new ResponseEntity<String>("Booking with passengerid->"+passengerid +" "+ "deleted successfully.",HttpStatus.OK);
	
	}	

}
