package es.flightsearch;

import java.util.List;

import es.flightsearch.model.Ticket;
import es.flightsearch.service.FlightSearchService;

public class FlightSearch {

	public static void main(String[] args) {
		if (args.length != 6) {
			System.out.println("USAGE: es.flightsearch.FlightSearch numAdults numChilds numInfants daysToDeparture origin destination");
		} else {
			FlightSearchService service = new FlightSearchService();
			List<Ticket> results = service.searchFlights(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]),
			        Integer.parseInt(args[3]), args[4], args[5]);
			for (Ticket ticket : results) {
				System.out.println(ticket.toString());
			}
		}
	}

}
