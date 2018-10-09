package au.com.whispir.robot.simulation.model.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import au.com.whispir.robot.simulation.model.Direction;
import au.com.whispir.robot.simulation.model.Location;
import au.com.whispir.robot.simulation.model.factory.MovementResolverFactory;
import au.com.whispir.robot.simulation.model.factory.MovementResolverFactory.DirectedMovementResolver;

/**
 * Test case for test-driving feature development of Movement Resolver Factory.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class MovementResolverFactoryTest {

	private Location location;
	
	@Before
	public void setUp() throws Exception {
		location = new Location(2, 2);		
	}
	
	@Test
	public void testMovementResolverRetrieval() {
		DirectedMovementResolver resolver = MovementResolverFactory.getDirectedMovementResolver(Direction.EAST);
		assertEquals(resolver, DirectedMovementResolver.EAST_DIRECTED_MOVEMENT_RESOLVER);
		
		resolver = MovementResolverFactory.getDirectedMovementResolver(Direction.WEST);
		assertEquals(resolver, DirectedMovementResolver.WEST_DIRECTED_MOVEMENT_RESOLVER);
		
		resolver = MovementResolverFactory.getDirectedMovementResolver(Direction.NORTH);
		assertEquals(resolver, DirectedMovementResolver.NORTH_DIRECTED_MOVEMENT_RESOLVER);
		
		resolver = MovementResolverFactory.getDirectedMovementResolver(Direction.SOUTH);
		assertEquals(resolver, DirectedMovementResolver.SOUTH_DIRECTED_MOVEMENT_RESOLVER);
		
		resolver = MovementResolverFactory.getDirectedMovementResolver(null);
		assertNull(resolver);
	}
	
	@Test
	public void testAdvanceEastByUnitStep() {		
		DirectedMovementResolver.EAST_DIRECTED_MOVEMENT_RESOLVER.advanceByUnitStep(location);	
		
		assertEquals(location.getXCoordinate(), 3);
		assertEquals(location.getYCoordinate(), 2);		
	}
	
	@Test
	public void testAdvanceWestByUnitStep() {		
		DirectedMovementResolver.WEST_DIRECTED_MOVEMENT_RESOLVER.advanceByUnitStep(location);
		
		assertEquals(location.getXCoordinate(), 1);
		assertEquals(location.getYCoordinate(), 2);		
	}
	
	@Test
	public void testAdvanceNorthByUnitStep() {
		DirectedMovementResolver.NORTH_DIRECTED_MOVEMENT_RESOLVER.advanceByUnitStep(location);
		
		assertEquals(location.getXCoordinate(), 2);
		assertEquals(location.getYCoordinate(), 3);		
	}
	
	@Test
	public void testAdvanceSouthByUnitStep() {	
		DirectedMovementResolver.SOUTH_DIRECTED_MOVEMENT_RESOLVER.advanceByUnitStep(location);
		
		assertEquals(location.getXCoordinate(), 2);
		assertEquals(location.getYCoordinate(), 1);		
	}
}
