package au.com.whispir.robot.simulation.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import au.com.whispir.robot.simulation.model.Direction;
import au.com.whispir.robot.simulation.model.Location;
import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.TableSurface;

/**
 * Test case for test-driving TableSurface feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class TableSurfaceTest {
	
	private TableSurface tableSurface;
	
	@Before
	public void setUp() throws Exception {
		tableSurface = new TableSurface();
	}
	
	@Test
	public void testTableSurfaceBounds() {		
		assertNotNull(tableSurface);
		assertEquals(tableSurface.getSouthWestCorner(), new Location(0, 0));
		assertEquals(tableSurface.getNorthEastCorner(), new Location(5, 5));
	}
	
	@Test
	public void testValidPositionOnSurface() {
		Position position = new Position(new Location(2, 3), Direction.NORTH);
		assertTrue(tableSurface.isPositionValidOnSurface(position));		
	}
	
	@Test
	public void testInvalidPositionOnSurface() {
		Position position = new Position(new Location(6, 5), Direction.NORTH);
		assertFalse(tableSurface.isPositionValidOnSurface(position));	
		
		position = new Position(new Location(4, 5), null);
		assertFalse(tableSurface.isPositionValidOnSurface(position));	
	}
	
	@Test
	public void testPositionOnSurfaceEdge() {
		Position position = new Position(new Location(4, 4), Direction.NORTH);
		assertFalse(tableSurface.isPositionOnSurfaceEdge(position));		
		position = new Position(new Location(4, 5), Direction.NORTH);
		assertTrue(tableSurface.isPositionOnSurfaceEdge(position));	
		
		position = new Position(new Location(4, 4), Direction.SOUTH);
		assertFalse(tableSurface.isPositionOnSurfaceEdge(position));		
		position = new Position(new Location(4, 0), Direction.SOUTH);
		assertTrue(tableSurface.isPositionOnSurfaceEdge(position));	
		
		position = new Position(new Location(4, 4), Direction.EAST);
		assertFalse(tableSurface.isPositionOnSurfaceEdge(position));		
		position = new Position(new Location(5, 4), Direction.EAST);
		assertTrue(tableSurface.isPositionOnSurfaceEdge(position));	
		
		position = new Position(new Location(4, 4), Direction.WEST);
		assertFalse(tableSurface.isPositionOnSurfaceEdge(position));		
		position = new Position(new Location(0, 4), Direction.WEST);
		assertTrue(tableSurface.isPositionOnSurfaceEdge(position));			
	}
}
