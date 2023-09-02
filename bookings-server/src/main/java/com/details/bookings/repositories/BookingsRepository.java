package com.details.bookings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.bookings.entities.Booking;

public interface BookingsRepository extends JpaRepository<Booking,String>{

}
