package com.details.payment.paymentssserver.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.details.payment.paymentssserver.entities.Payment;

public interface PaymentService {
	
    public Payment createPayment(Payment payment);
	
	public ResponseEntity<String> deletePayment(@PathVariable String paymentid);
		
	public Payment getPayment(String bookingid);

}
