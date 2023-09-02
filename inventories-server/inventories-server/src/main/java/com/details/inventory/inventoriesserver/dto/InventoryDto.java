package com.details.inventory.inventoriesserver.dto;

import java.util.List;

public class InventoryDto {

	private String inventoryid;

	private String busid;

	private List<String> availableSeats;

	private String lastUpdatedDate;
	
	public InventoryDto()
	{
		
	}

	public InventoryDto(String inventoryid, String busid, List<String> availableSeats, String lastUpdatedDate) {
		super();
		this.inventoryid = inventoryid;
		this.busid = busid;
		this.availableSeats = availableSeats;
		this.lastUpdatedDate = lastUpdatedDate;
	}

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
