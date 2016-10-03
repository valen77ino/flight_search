package es.flightsearch.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import es.flightsearch.model.Ticket;

public class FlightSearchServiceTest {

	@Test
	public void test1() {
		FlightSearchService service = new FlightSearchService();
		List<Ticket> results = service.searchFlights(1, 0, 0, 30, "AMS", "FRA");
		Assert.assertEquals(results.size(), 3);
		Ticket ticket = results.get(0);
		Assert.assertEquals(ticket.getFlightCode(), "TK2372");
		Assert.assertEquals(Math.round(ticket.getFlightPrice().doubleValue() * 100.0) / 100.0, 157.6, 0);
		ticket = results.get(1);
		Assert.assertEquals(ticket.getFlightCode(), "TK2659");
		Assert.assertEquals(Math.round(ticket.getFlightPrice().doubleValue() * 100.0) / 100.0, 198.4, 0);
		ticket = results.get(2);
		Assert.assertEquals(ticket.getFlightCode(), "LH5909");
		Assert.assertEquals(Math.round(ticket.getFlightPrice().doubleValue() * 100.0) / 100.0, 90.4, 0);
	}

	@Test
	public void test2() {
		FlightSearchService service = new FlightSearchService();
		List<Ticket> results = service.searchFlights(2, 1, 1, 15, "LHR", "IST");
		Assert.assertEquals(results.size(), 2);
		Ticket ticket = results.get(0);
		Assert.assertEquals(ticket.getFlightCode(), "TK8891");
		Assert.assertEquals(Math.round(ticket.getFlightPrice().doubleValue() * 100.0) / 100.0, 806, 0);
		ticket = results.get(1);
		Assert.assertEquals(ticket.getFlightCode(), "LH1085");
		Assert.assertEquals(Math.round(ticket.getFlightPrice().doubleValue() * 100.0) / 100.0, 481.19, 0);
	}

	@Test
	public void test3() {
		FlightSearchService service = new FlightSearchService();
		List<Ticket> results = service.searchFlights(1, 2, 0, 2, "BCN", "MAD");
		Ticket ticket = results.get(0);
		Assert.assertEquals(results.size(), 2);
		Assert.assertEquals(ticket.getFlightCode(), "IB2171");
		Assert.assertEquals(Math.round(ticket.getFlightPrice().doubleValue() * 100.0) / 100.0, 909.09, 0);
		ticket = results.get(1);
		Assert.assertEquals(ticket.getFlightCode(), "LH5496");
		Assert.assertEquals(Math.round(ticket.getFlightPrice().doubleValue() * 100.0) / 100.0, 1028.43, 0);
	}

	@Test
	public void test4() {
		FlightSearchService service = new FlightSearchService();
		List<Ticket> results = service.searchFlights(0, 0, 0, 0, "CDG", "FRA");
		Assert.assertEquals(results.size(), 0);
	}
}
