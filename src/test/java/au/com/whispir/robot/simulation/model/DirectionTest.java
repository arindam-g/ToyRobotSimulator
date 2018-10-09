package au.com.whispir.robot.simulation.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import au.com.whispir.robot.simulation.model.Direction;

/**
 * Test case for test-driving Direction feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class DirectionTest {
	
	@Test
	public void testCompassPoints() {		
		assertEquals(Direction.EAST.toString(), "EAST");
		assertEquals(Direction.WEST.toString(), "WEST");
		assertEquals(Direction.NORTH.toString(), "NORTH");
		assertEquals(Direction.SOUTH.toString(), "SOUTH");
	}
	
	@Test
	public void testRotateClockwiseFromNorth() {		
		Direction direction = Direction.NORTH.rotateClockwise();		
		assertEquals(direction, Direction.EAST);		
	}
	
	@Test
	public void testRotateClockwiseFromSouth() {		
		Direction direction = Direction.SOUTH.rotateClockwise();
		assertEquals(direction, Direction.WEST);		
	}
	
	@Test
	public void testRotateClockwiseFromEast() {		
		Direction direction = Direction.EAST.rotateClockwise();
		assertEquals(direction, Direction.SOUTH);		
	}
	
	@Test
	public void testRotateClockwiseFromWest() {		
		Direction direction = Direction.WEST.rotateClockwise();
		assertEquals(direction, Direction.NORTH);		
	}
	
	@Test
	public void testRotateAntiClockwiseFromNorth() {		
		Direction direction = Direction.NORTH.rotateAntiClockwise();		
		assertEquals(direction, Direction.WEST);		
	}
	
	@Test
	public void testRotateAntiClockwiseFromSouth() {		
		Direction direction = Direction.SOUTH.rotateAntiClockwise();
		assertEquals(direction, Direction.EAST);		
	}
	
	@Test
	public void testRotateAntiClockwiseFromEast() {		
		Direction direction = Direction.EAST.rotateAntiClockwise();
		assertEquals(direction, Direction.NORTH);		
	}
	
	@Test
	public void testRotateAntiClockwiseFromWest() {		
		Direction direction = Direction.WEST.rotateAntiClockwise();
		assertEquals(direction, Direction.SOUTH);		
	}
}
