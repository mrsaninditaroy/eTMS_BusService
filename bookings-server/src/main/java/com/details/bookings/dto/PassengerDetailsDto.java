package com.details.bookings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class PassengerDetailsDto {

	private String passengerid;

	private String ticketid;

	public PassengerDetailsDto() {

	}

	public PassengerDetailsDto(String passengerid,String ticketid) {
		super();
		this.passengerid = passengerid;
		this.ticketid = ticketid;
	}

	public String getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(String passengerid) {
		this.passengerid = passengerid;
	}

	public String getTicketid() {
		return ticketid;
	}

	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

}
