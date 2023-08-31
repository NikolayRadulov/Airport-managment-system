package com.app.airport.model.dto;

import java.math.BigDecimal;


public class TicketSearchDto {

	private String sourceCountry;
	private String destinationCountry;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	
	
	public TicketSearchDto() {
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


	public BigDecimal getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}


	public BigDecimal getMaxPrice() {
		return maxPrice;
	}


	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}


	
}
