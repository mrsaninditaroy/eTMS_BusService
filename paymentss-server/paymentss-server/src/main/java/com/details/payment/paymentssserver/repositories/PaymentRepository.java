package com.details.payment.paymentssserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.payment.paymentssserver.entities.*;

public interface PaymentRepository extends JpaRepository<Payment,String>{

}
