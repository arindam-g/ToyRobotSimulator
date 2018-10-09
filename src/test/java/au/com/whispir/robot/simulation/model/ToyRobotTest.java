package au.com.whispir.robot.simulation.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import au.com.whispir.robot.simulation.model.Direction;
import au.com.whispir.robot.simulation.model.Location;
import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.TableSurface;
import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * Test case for test-driving ToyRobot feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class ToyRobotTest {

	private ToyRobot robot;
	
	@Before
	public void setUp() throws Exception {
		robot = new ToyRobot(new TableSurface());	
	}
	
	@Test
	public void testMoveForwardNullPosition() {
		robot.moveForward();
		Position robotPosition = robot.reportCurrentPosition();
		assertNull(robotPosition);
	}
	
	@Test
	public void testMoveForwardNorth() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.NORTH));
		robot.moveForward();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 3);
		assertEquals(robotPosition.getOrientation(), Direction.NORTH);
	}
	
	@Test
	public void testMoveForwardSouth() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.SOUTH));
		robot.moveForward();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 1);
		assertEquals(robotPosition.getOrientation(), Direction.SOUTH);
	}
	
	@Test
	public void testMoveForwardEast() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.EAST));
		robot.moveForward();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 3);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.EAST);
	}
	
	@Test
	public void testMoveForwardWest() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.WEST));
		robot.moveForward();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 1);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.WEST);
	}
	
	@Test
	public void testTurnLeftFromNullPosition() {
		robot.turnLeft();
		Position robotPosition = robot.reportCurrentPosition();
		assertNull(robotPosition);
	}
	
	@Test
	public void testTurnLeftFromNorth() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.NORTH));
		robot.turnLeft();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.WEST);		
	}
	
	@Test
	public void testTurnLeftFromSouth() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.SOUTH));
		robot.turnLeft();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.EAST);		
	}
	
	@Test
	public void testTurnLeftFromEast() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.EAST));
		robot.turnLeft();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.NORTH);		
	}
	
	@Test
	public void testTurnLeftFromWest() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.WEST));
		robot.turnLeft();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.SOUTH);		
	}	
	
	@Test
	public void testTurnRightFromNullPosition() {
		robot.turnRight();
		Position robotPosition = robot.reportCurrentPosition();
		assertNull(robotPosition);
	}
	
	@Test
	public void testTurnRightFromNorth() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.NORTH));
		robot.turnRight();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.EAST);		
	}
	
	@Test
	public void testTurnRightFromSouth() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.SOUTH));
		robot.turnRight();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.WEST);		
	}
	
	@Test
	public void testTurnRightFromEast() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.EAST));
		robot.turnRight();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.SOUTH);		
	}
	
	@Test
	public void testTurnRightFromWest() {		
		robot.placeAtPosition(new Position(new Location(2, 2), Direction.WEST));
		robot.turnRight();
		
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition.getLocation().getXCoordinate(), 2);
		assertEquals(robotPosition.getLocation().getYCoordinate(), 2);
		assertEquals(robotPosition.getOrientation(), Direction.NORTH);		
	}
	
	@Test
	public void testReportCurrentPosition() {
		Position robotPosition = robot.reportCurrentPosition();
		assertNull(robotPosition);
		
		robot.placeAtPosition(new Position(new Location(4, 2), Direction.SOUTH));
		robotPosition = robot.reportCurrentPosition();
		assertNotNull(robotPosition);
	}	
	
	@Test
	public void testPlaceAtValidPosition() {
		robot.placeAtPosition(new Position(new Location(4, 3), Direction.WEST));
		Position robotPosition = robot.reportCurrentPosition();
		assertNotNull(robotPosition);
	}
	
	@Test
	public void testPlaceAtInvalidPositionAfterNullPosition() {
		robot.placeAtPosition(new Position(new Location(6, 3), Direction.WEST));
		Position robotPosition = robot.reportCurrentPosition();
		assertNull(robotPosition);
	}
	
	@Test
	public void testPlaceAtInvalidPositionAfterValidPosition() {
		robot.placeAtPosition(new Position(new Location(4, 3), Direction.NORTH));
		robot.placeAtPosition(new Position(new Location(6, 3), Direction.WEST));
		Position robotPosition = robot.reportCurrentPosition();
		
		assertNotNull(robotPosition);
		assertEquals(robotPosition, new Position(new Location(4, 3), Direction.NORTH));		
	}
	
	@Test
	public void testMoveForwardIgnoredAtSurfaceEdge() {		
		robot.placeAtPosition(new Position(new Location(4, 5), Direction.NORTH));
		robot.moveForward();
		Position robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition, new Position(new Location(4, 5), Direction.NORTH));
		
		robot.placeAtPosition(new Position(new Location(4, 0), Direction.SOUTH));
		robot.moveForward();
		robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition, new Position(new Location(4, 0), Direction.SOUTH));
		
		robot.placeAtPosition(new Position(new Location(5, 4), Direction.EAST));
		robot.moveForward();
		robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition, new Position(new Location(5, 4), Direction.EAST));
		
		robot.placeAtPosition(new Position(new Location(0, 4), Direction.WEST));
		robot.moveForward();
		robotPosition = robot.reportCurrentPosition();
		assertEquals(robotPosition, new Position(new Location(0, 4), Direction.WEST));	
	}
}
