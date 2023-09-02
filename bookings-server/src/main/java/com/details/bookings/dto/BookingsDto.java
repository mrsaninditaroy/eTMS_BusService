package com.details.bookings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BookingsDto {
		
		private String bookingid;

		private String busid;

		private String source;

		private String destination;

		private String noOfSeats;

		private String bookingdate;

		private String bookingStatus;
		
		private String inventoryid;
		
		public BookingsDto()
		{
			
		}
		
		 public BookingsDto(String bookingid, String busid, String source, String destination, String noOfSeats,
					String bookingdate, String bookingStatus,String inventoryid) {
				super();
				this.bookingid = bookingid;
				this.busid = busid;
				this.source = source;
				this.destination = destination;
				this.noOfSeats = noOfSeats;
				this.bookingdate = bookingdate;
				this.bookingStatus = bookingStatus;
				this.inventoryid = inventoryid;
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

		public String getInventoryid() {
			return inventoryid;
		}

		public void setInventoryid(String inventoryid) {
			this.inventoryid = inventoryid;
		}
	

}
