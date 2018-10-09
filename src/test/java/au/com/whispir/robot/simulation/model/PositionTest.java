package au.com.whispir.robot.simulation.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import au.com.whispir.robot.simulation.model.Direction;
import au.com.whispir.robot.simulation.model.Location;
import au.com.whispir.robot.simulation.model.Position;

/**
 * Test case for test-driving Position feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class PositionTest {
	
	private Position position;
	
	@Before
	public void setUp() throws Exception {
		position = new Position(new Location(1, 2), Direction.NORTH);
	}
	
	@Test
	public void testPositionCreation() {		
		assertNotNull(position);
	}
	
	@Test
	public void testPositionValue() {		
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.NORTH);
	}
	
	@Test
	public void testAdvanceLocationByUnitStep() {
		position.advanceLocationByUnitStep();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 3);
		assertEquals(position.getOrientation(), Direction.NORTH);
		
		position = new Position(new Location(1, 2), Direction.SOUTH);
		position.advanceLocationByUnitStep();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 1);
		assertEquals(position.getOrientation(), Direction.SOUTH);
		
		position = new Position(new Location(1, 2), Direction.EAST);
		position.advanceLocationByUnitStep();
		assertEquals(position.getLocation().getXCoordinate(), 2);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.EAST);
		
		position = new Position(new Location(1, 2), Direction.WEST);
		position.advanceLocationByUnitStep();
		assertEquals(position.getLocation().getXCoordinate(), 0);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.WEST);		
	}
	
	@Test
	public void testRotateOrientationClockwise() {
		position.rotateOrientationClockwise();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.EAST);
		
		position = new Position(new Location(1, 2), Direction.SOUTH);
		position.rotateOrientationClockwise();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.WEST);
		
		position = new Position(new Location(1, 2), Direction.EAST);
		position.rotateOrientationClockwise();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.SOUTH);
		
		position = new Position(new Location(1, 2), Direction.WEST);
		position.rotateOrientationClockwise();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.NORTH);
		
	}
	
	@Test
	public void testRotateOrientationAntiClockwise() {
		position.rotateOrientationAntiClockwise();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.WEST);
		
		position = new Position(new Location(1, 2), Direction.SOUTH);
		position.rotateOrientationAntiClockwise();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.EAST);
		
		position = new Position(new Location(1, 2), Direction.EAST);
		position.rotateOrientationAntiClockwise();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.NORTH);
		
		position = new Position(new Location(1, 2), Direction.WEST);
		position.rotateOrientationAntiClockwise();
		assertEquals(position.getLocation().getXCoordinate(), 1);
		assertEquals(position.getLocation().getYCoordinate(), 2);
		assertEquals(position.getOrientation(), Direction.SOUTH);		
	}
	
	@Test
	public void testPositionStringRepresentation() {		
		assertEquals(position.toString(), "1, 2, NORTH");		
	}
}
