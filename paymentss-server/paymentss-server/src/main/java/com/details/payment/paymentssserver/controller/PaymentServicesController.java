package com.details.payment.paymentssserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.details.payment.paymentssserver.entities.Payment;
import com.details.payment.paymentssserver.services.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class PaymentServicesController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("createPayment")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {

		Payment savedPayment = paymentService.createPayment(payment);

		return new ResponseEntity<Payment>(savedPayment, HttpStatus.CREATED);
	}	
	
	@DeleteMapping("/paymentss/{paymentid}/deletePayment")
	public ResponseEntity<String> delete(@PathVariable("paymentid") String paymentid) {
		
		return  new ResponseEntity<String>("Booking with paymentid->"+paymentid +" "+ "deleted successfully.",HttpStatus.OK);
	
	}	

}
