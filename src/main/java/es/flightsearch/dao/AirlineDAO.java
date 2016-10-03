package es.flightsearch.dao;

import java.util.HashMap;

public class AirlineDAO {

	private HashMap<String, Double> datasource;

	public AirlineDAO() {
		super();
		this.datasource = new HashMap<String, Double>();
		this.datasource.put("IB", new Double(10));
		this.datasource.put("BA", new Double(15));
		this.datasource.put("LH", new Double(7));
		this.datasource.put("FR", new Double(20));
		this.datasource.put("VY", new Double(10));
		this.datasource.put("TK", new Double(5));
		this.datasource.put("U2", new Double(19.90));
	}

	public Double readInfantPrice(String iataCode) {
		return datasource.get(iataCode);
	}

}
