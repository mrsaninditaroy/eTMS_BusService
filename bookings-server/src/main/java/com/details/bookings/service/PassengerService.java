package com.details.bookings.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.details.bookings.entities.PassengerDetails;

public interface PassengerService {
	
	public ResponseEntity<String> deletePassenger(@PathVariable String passengerid);
	
	public PassengerDetails createPassenger(PassengerDetails passenger);
}
