package com.details.payment.paymentssserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.details.payment.paymentssserver.entities.Payment;
import com.details.payment.paymentssserver.repositories.PaymentRepository;
import com.details.payment.paymentssserver.services.PaymentService;

public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Payment createPayment(Payment payment) {
	
		return (paymentRepository.save(payment));
	}

	@Override
	public ResponseEntity<String> deletePayment(String paymentid) {
		return new ResponseEntity<String>("Payment with paymentid->"+paymentid +" "+ "deleted successfully.",HttpStatus.OK);
	}
	
	@Override
	public Payment getPayment(String bookingid) {
		
		Payment payment =  paymentRepository.findById(bookingid).get();
		
		return payment;
	}


}
