package com.details.bookings.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@Column(name = "bookingid", length = 50)
	private String bookingid;

	@Column(name = "inventoryid", length = 50)
	private String inventoryid;

	@Column(name = "busid",length = 50)
	private String busid;

	@Column(name = "source", nullable = false, length = 50)
	private String source;

	@Column(name = "destination", nullable = false, length = 50)
	private String destination;

	@Column(name = "noOfSeats", nullable = false, length = 50)
	private String noOfSeats;

	@Column(name = "bookingdate", nullable = false, length = 50)
	private String bookingdate;

	@Column(name = "bookingStatus", nullable = false, length = 50)
	private String bookingStatus;

	public Booking(String bookingid, String busid, String source, String destination, String noOfSeats,
			String bookingdate, String bookingStatus) {
		super();
		this.bookingid = bookingid;
		this.busid = busid;
		this.source = source;
		this.destination = destination;
		this.noOfSeats = noOfSeats;
		this.bookingdate = bookingdate;
		this.bookingStatus = bookingStatus;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(String inventoryid) {
		this.inventoryid = inventoryid;
	}

}
