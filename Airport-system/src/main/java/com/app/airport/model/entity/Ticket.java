package com.app.airport.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

	@Column(nullable = false, name = "source_country")
	private String sourceCountry;
	
	@Column(nullable = false, name = "destination_country")
	private String destinationCountry;

	@Column(nullable = false)
	private BigDecimal price;
	
	@Column(nullable = false, name = "department_time")
	private LocalDateTime departmentTime;
	
	@Column(nullable = false, name = "arrival_time")
	private LocalDateTime arrivalTime;
	
	@ManyToOne
	private User user;
	
	public Ticket(String sourceCounty, String destinationCounty, BigDecimal price, LocalDateTime departmentTime,
			LocalDateTime arrivalTime) {
		this.sourceCountry = sourceCounty;
		this.destinationCountry = destinationCounty;
		this.price = price;
		this.departmentTime = departmentTime;
		this.arrivalTime = arrivalTime;
	}

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public String getSourceCountry() {
		return sourceCountry;
	}

	public void setSourceCountry(String sourceCounty) {
		this.sourceCountry = sourceCounty;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCounty) {
		this.destinationCountry = destinationCounty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getDepartmentTime() {
		return departmentTime;
	}

	public void setDepartmentTime(LocalDateTime departmentTime) {
		this.departmentTime = departmentTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
