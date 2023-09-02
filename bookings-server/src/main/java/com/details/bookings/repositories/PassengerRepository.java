package com.details.bookings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.bookings.entities.PassengerDetails;

public interface PassengerRepository extends JpaRepository<PassengerDetails,String>{

}
