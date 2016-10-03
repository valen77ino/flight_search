package es.flightsearch.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.flightsearch.model.Flight;

public class FlightsDAO {

	// private HashMap<String, Flight> datasource;
	private List<Flight> datasource;

	public FlightsDAO() {
		super();
		this.datasource = new ArrayList<Flight>();
		addRecordToDatasource(datasource, "CPH", "FRA", "IB2818", 186);
		addRecordToDatasource(datasource, "CPH", "LHR", "U23631", 152);
		addRecordToDatasource(datasource, "CDG", "MAD", "IB8482", 295);
		addRecordToDatasource(datasource, "BCN", "FRA", "FR7521", 150);
		addRecordToDatasource(datasource, "CPH", "FCO", "TK4667", 137);
		addRecordToDatasource(datasource, "CPH", "FCO", "U24631", 268);
		addRecordToDatasource(datasource, "FCO", "CDG", "VY4335", 158);
		addRecordToDatasource(datasource, "FRA", "AMS", "U24107", 237);
		addRecordToDatasource(datasource, "CPH", "BCN", "U22593", 218);

		addRecordToDatasource(datasource, "AMS", "FRA", "TK2372", 197);
		addRecordToDatasource(datasource, "AMS", "FRA", "TK2659", 248);
		addRecordToDatasource(datasource, "AMS", "FRA", "LH5909", 113);

		addRecordToDatasource(datasource, "LHR", "IST", "TK8891", 250);
		addRecordToDatasource(datasource, "LHR", "IST", "LH1085", 148);

		addRecordToDatasource(datasource, "BCN", "MAD", "IB2171", 259);
		addRecordToDatasource(datasource, "BCN", "MAD", "LH5496", 293);
	}

	private void addRecordToDatasource(List<Flight> datasource, String origin, String destination, String flightCode, float basePrice) {
		datasource.add(new Flight(origin, destination, flightCode, new Float(basePrice)));
	}

	public List<Flight> readFlights(String origin, String destination) {
		List<Flight> resultList = new ArrayList<Flight>();
		Flight flight = null;
		for (Iterator<Flight> iterator = this.datasource.iterator(); iterator.hasNext();) {
			flight = (Flight) iterator.next();
			if (flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination)) {
				resultList.add(flight);
			}
		}
		return resultList;
	}
}
