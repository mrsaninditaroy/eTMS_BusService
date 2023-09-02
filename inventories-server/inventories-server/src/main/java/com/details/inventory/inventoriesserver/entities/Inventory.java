package com.details.inventory.inventoriesserver.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

    @Entity
	@Table(name = "inventories")
	public class Inventory {
	    @Id
	    @Column(name = "inventoryid", nullable = false, length = 10)
	    private String inventoryid;

	    @Column(name = "busid", length = 10)
	    private String busid;

	    @Column(name = "availableSeats", length = 10)
	    private List<String> availableSeats;

	    @Column(name = "lastUpdatedDate", length = 10)
	    private String lastUpdatedDate;

		public String getInventoryid() {
			return inventoryid;
		}

		public void setInventoryid(String inventoryid) {
			this.inventoryid = inventoryid;
		}

		public String getBusid() {
			return busid;
		}

		public void setBusid(String busid) {
			this.busid = busid;
		}

		public List<String> getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(List<String> availableSeats) {
			this.availableSeats = availableSeats;
		}

		public String getLastUpdatedDate() {
			return lastUpdatedDate;
		}

		public void setLastUpdatedDate(String lastUpdatedDate) {
			this.lastUpdatedDate = lastUpdatedDate;
		}

	}

	

