package es.flightsearch.model;

public class Flight {

	private String origin;
	private String destination;
	private String flightCode;
	private Float basePrice;

	public Flight() {
		super();
	}

	public Flight(String origin, String destination, String flightCode, Float basePrice) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightCode = flightCode;
		this.basePrice = basePrice;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}

	public String getAirlineCode() {
		return this.flightCode.substring(0, 2);
	}

}
