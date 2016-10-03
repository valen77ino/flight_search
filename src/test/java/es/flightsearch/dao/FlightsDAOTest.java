/**
 * 
 */
package es.flightsearch.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.flightsearch.model.Flight;

/**
 * @author user
 *
 */
public class FlightsDAOTest {
	private FlightsDAO dao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.dao = new FlightsDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFlights() {
		List<Flight> resultList;
		resultList = this.dao.readFlights("AMS", "FRA");
		assertEquals(resultList.size(), 3);
		resultList = this.dao.readFlights("LHR", "IST");
		assertEquals(resultList.size(), 2);
		resultList = this.dao.readFlights("BCN", "MAD");
		assertEquals(resultList.size(), 2);
		resultList = this.dao.readFlights("CDG", "FRA");
		assertEquals(resultList.size(), 0);
	}

}
