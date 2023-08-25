package com.app.airport.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TicketDto {

	@NotNull
	@Size(min = 4)
	private String sourceCounty;
	
	@NotNull
	@Size(min = 4)
	private String destinationCounty;

	@NotNull
	@Positive
	private BigDecimal price;
	
	@NotNull
	private LocalDateTime departmentTime;
	
	@NotNull
	private LocalDateTime arrivalTime;
	
	public TicketDto() {
		// TODO Auto-generated constructor stub
	}

	public String getSourceCounty() {
		return sourceCounty;
	}

	public void setSourceCounty(String sourceCounty) {
		this.sourceCounty = sourceCounty;
	}

	public String getDestinationCounty() {
		return destinationCounty;
	}

	public void setDestinationCounty(String destinationCounty) {
		this.destinationCounty = destinationCounty;
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

}
