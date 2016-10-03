package es.flightsearch.model;

public class Ticket {

	private String flightCode;

	private Double flightPrice;

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Double getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(Double flightPrice) {
		this.flightPrice = flightPrice;
	}

	@Override
	public String toString() {
		return flightCode + ", " + Math.round(flightPrice * 100.0) / 100.0 + " €";
	}

}
