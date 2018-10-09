package au.com.whispir.robot.simulation.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import au.com.whispir.robot.simulation.model.Location;

/**
 * Test case for test-driving Location feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class LocationTest {	
	
	private Location location;
	
	@Before
	public void setUp() throws Exception {
		location = new Location(2, 5);		
	}
	
	@Test
	public void testLocationValue() {		
		assertEquals(location.getXCoordinate(), 2);
		assertEquals(location.getYCoordinate(), 5);		
	}
	
	@Test
	public void testIncrementXCoordinate() {
		location.incrementXCoordinate();
		assertEquals(location.getXCoordinate(), 3);
		assertEquals(location.getYCoordinate(), 5);		
	}
	
	@Test
	public void testDecrementXCoordinate() {
		location.decrementXCoordinate();
		assertEquals(location.getXCoordinate(), 1);
		assertEquals(location.getYCoordinate(), 5);		
	}
	
	@Test
	public void testIncrementYCoordinate() {
		location.incrementYCoordinate();
		assertEquals(location.getXCoordinate(), 2);
		assertEquals(location.getYCoordinate(), 6);		
	}
	
	@Test
	public void testDecrementYCoordinate() {
		location.decrementYCoordinate();
		assertEquals(location.getXCoordinate(), 2);
		assertEquals(location.getYCoordinate(), 4);		
	}
	
	@Test
	public void testLocationStringRepresentation() {		
		assertEquals(location.toString(), "2, 5");		
	}
}
