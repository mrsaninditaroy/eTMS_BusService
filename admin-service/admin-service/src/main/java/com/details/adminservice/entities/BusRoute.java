package com.details.adminservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "busroutes",schema="my")
public class BusRoute {
	
	@Id
	@Column(name = "routeid", length = 50)
    private String routeid;    
    
    @Column(name = "busid", nullable = false, length = 50)
    private String busid;
    
    @Column(name = "source", nullable = false, length = 50)
    private String source;

    @Column(name = "destination", length = 50)
    private String destination;
    
    @Column(name = "price", length = 50)
    private String price;

	public String getRouteid() {
		return routeid;
	}

	public void setRouteid(String routeid) {
		this.routeid = routeid;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
