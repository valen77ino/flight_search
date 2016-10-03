package es.flightsearch.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.flightsearch.dao.AirlineDAO;
import es.flightsearch.dao.FlightsDAO;
import es.flightsearch.model.Flight;
import es.flightsearch.model.Ticket;

public class FlightSearchService {

	private FlightsDAO flightsDAO;
	private AirlineDAO airlineDAO;

	public FlightSearchService() {
		super();
		this.flightsDAO = new FlightsDAO();
		this.airlineDAO = new AirlineDAO();
	}

	public List<Ticket> searchFlights(int numAdults, int numChilds, int numInfants, int daysToDeparture, String origin, String destination) {
		List<Ticket> resultList = new ArrayList<Ticket>();
		List<Flight> listFlights = this.flightsDAO.readFlights(origin, destination);
		for (Iterator<Flight> iterator = listFlights.iterator(); iterator.hasNext();) {
			Flight flight = (Flight) iterator.next();
			resultList.add(generateTicket(flight, numAdults, numChilds, numInfants, daysToDeparture));
		}
		return resultList;
	}

	private Ticket generateTicket(Flight flight, int numAdults, int numChilds, int numInfants, int daysToDeparture) {
		Ticket ticket = new Ticket();
		ticket.setFlightCode(flight.getFlightCode());
		double departureFactor = getDepartureFactor(daysToDeparture);
		double adjustedPrice = departureFactor * flight.getBasePrice();
		double finalAdultPrice = (numAdults * adjustedPrice);
		double finalChildPrice = (numChilds * (adjustedPrice * 0.67));
		double finalInfantPrice = (numInfants * getInfantPrice(flight.getAirlineCode()));
		double finalPrice = finalAdultPrice + finalChildPrice + finalInfantPrice;
		ticket.setFlightPrice(finalPrice);
		return ticket;
	}

	private double getInfantPrice(String airlineCode) {
		Double infantPrice = airlineDAO.readInfantPrice(airlineCode);
		if (infantPrice != null) {
			return infantPrice.doubleValue();
		}
		return 0;
	}

	private double getDepartureFactor(int daysToDeparture) {
		if (daysToDeparture >= 30) {
			return 0.8;
		} else if (daysToDeparture < 30 && daysToDeparture > 15) {
			return 1;
		} else if (daysToDeparture <= 15 && daysToDeparture >= 3) {
			return 1.2;
		} else {
			return 1.5;
		}
	}
}
