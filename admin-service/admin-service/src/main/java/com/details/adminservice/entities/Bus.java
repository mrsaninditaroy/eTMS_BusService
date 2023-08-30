package com.details.adminservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "buses")
public class Bus {
    @Id
    @Column(name = "busid", nullable = false, length = 10)
    private String busid;
    
    @Column(name = "busStatus", nullable = false, length = 10)
    private String busStatus;
    
    @Column(name = "busStoppages", nullable = false, length = 10)
    private String busStoppages;
    
    @Column(name = "busMovement", nullable = false, length = 10)
    private String busMovement;
    
    @Column(name = "tripTimingsUp", nullable = false, length = 10)
    private String tripTimingsUp;
    
    @Column(name = "tripTimingsDown", nullable = false, length = 10)
    private String tripTimingsDown;
    
    @Column(name = "seats", nullable = false, length = 10)
    private String seats;

	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public String getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(String busStatus) {
		this.busStatus = busStatus;
	}

	public String getBusStoppages() {
		return busStoppages;
	}

	public void setBusStoppages(String busStoppages) {
		this.busStoppages = busStoppages;
	}

	public String getBusMovement() {
		return busMovement;
	}

	public void setBusMovement(String busMovement) {
		this.busMovement = busMovement;
	}

	public String getTripTimingsUp() {
		return tripTimingsUp;
	}

	public void setTripTimingsUp(String tripTimingsUp) {
		this.tripTimingsUp = tripTimingsUp;
	}

	public String getTripTimingsDown() {
		return tripTimingsDown;
	}

	public void setTripTimingsDown(String tripTimingsDown) {
		this.tripTimingsDown = tripTimingsDown;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	
}