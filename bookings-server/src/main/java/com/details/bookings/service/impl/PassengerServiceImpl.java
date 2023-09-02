package com.details.bookings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.details.bookings.entities.PassengerDetails;
import com.details.bookings.repositories.PassengerRepository;
import com.details.bookings.service.PassengerService;

import lombok.AllArgsConstructor;

@Service
public class PassengerServiceImpl implements PassengerService{
	
	@Autowired
	private PassengerRepository passengerRepository;	

	@Override
	public ResponseEntity<String> deletePassenger(String passengerid) {
		return new ResponseEntity<String>("Booking with passengerid->"+passengerid +" "+ "deleted successfully.",HttpStatus.OK);
	}

	@Override
	public PassengerDetails createPassenger(PassengerDetails passenger) {
    
		PassengerDetails updatedPassenger = passengerRepository.save(passenger);
		
		return  updatedPassenger;
	}

	

}
