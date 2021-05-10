package com.demo;

import java.time.ZonedDateTime;

public class FlightEntity {

	private int flightId;
	private int flightNumber;
	private String departureAirportIATACode;
	private String arrivalAirportIATACode;
	private ZonedDateTime departureDate;
	
	public FlightEntity(int flightId, int flightNumber, String departureAirportIATACode, String arrivalAirportIATACode,
			ZonedDateTime departureDate) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.departureAirportIATACode = departureAirportIATACode;
		this.arrivalAirportIATACode = arrivalAirportIATACode;
		this.departureDate = departureDate;
	}
	
	public FlightEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureAirportIATACode() {
		return departureAirportIATACode;
	}

	public void setDepartureAirportIATACode(String departureAirportIATACode) {
		this.departureAirportIATACode = departureAirportIATACode;
	}

	public String getArrivalAirportIATACode() {
		return arrivalAirportIATACode;
	}

	public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
		this.arrivalAirportIATACode = arrivalAirportIATACode;
	}

	public ZonedDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(ZonedDateTime departureDate) {
		this.departureDate = departureDate;
	}

	@Override
	public String toString() {
		return "FlightEntity [flightId=" + flightId + ", flightNumber=" + flightNumber + ", departureAirportIATACode="
				+ departureAirportIATACode + ", arrivalAirportIATACode=" + arrivalAirportIATACode + ", departureDate="
				+ departureDate + "]";
	}
	
	
	

}
