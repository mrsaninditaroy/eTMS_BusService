package com.details.bookings.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class PassengerDetails {
    @Id    
    @Column(name = "passengerid", length = 50)
    private String passengerid;
    
    @Column(name = "bookingid", nullable = false, length = 10)
    private String ticketid;
    
    public PassengerDetails()
    {
    	
    }
    
    public PassengerDetails(String passengerid,String ticketid)
    {
    	this.passengerid= passengerid;
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