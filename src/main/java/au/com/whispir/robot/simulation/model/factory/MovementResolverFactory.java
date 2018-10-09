package au.com.whispir.robot.simulation.model.factory;

import au.com.whispir.robot.simulation.model.Direction;
import au.com.whispir.robot.simulation.model.Location;

/**
 * This FACTORY class is responsible for furnishing appropriate instances 
 * of movement resolvers.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class MovementResolverFactory {
	
	/**
	 * Returns the resolver object pertaining to movement in the specified direction.
	 * @param direction
	 * @return DirectedMovementResolver
	 */
	public static DirectedMovementResolver getDirectedMovementResolver(Direction direction){
		return DirectedMovementResolver.valueOfDirection(direction);
	}
	
	/**
	 * A nested enumeration type representing resolvers for movements made in various directions.
	 * First-quadrant of coordinate axes is assumed.
	 * Implements the STRATEGY pattern, for the forward movement algorithm implementations.
	 * 
	 */
	public static enum DirectedMovementResolver {

		EAST_DIRECTED_MOVEMENT_RESOLVER {
			@Override
			public void advanceByUnitStep(Location location) {
				location.incrementXCoordinate();
			}
		}, 
		WEST_DIRECTED_MOVEMENT_RESOLVER {
			@Override
			public void advanceByUnitStep(Location location) {
				location.decrementXCoordinate();
			}
		}, 
		NORTH_DIRECTED_MOVEMENT_RESOLVER {
			@Override
			public void advanceByUnitStep(Location location) {
				location.incrementYCoordinate();
			}
		}, 
		SOUTH_DIRECTED_MOVEMENT_RESOLVER {
			@Override
			public void advanceByUnitStep(Location location) {
				location.decrementYCoordinate();
			}
		};
		
		private static final String RESOLVER_SUFFIX = "_DIRECTED_MOVEMENT_RESOLVER";
		
		/*
		 * Retrieves the movement resolver enum instance for the given direction.
		 * This method is accessible only by the outer factory class.
		 */
		private static DirectedMovementResolver valueOfDirection(Direction direction){
			if(direction != null){
				String directionName = direction.toString();
				return DirectedMovementResolver.valueOf(directionName + RESOLVER_SUFFIX);
			}
			return null;
		}
		
		/**
		 * Advances the given location by a single unit, in the current direction.
		 * @param location
		 */
		public abstract void advanceByUnitStep(Location location);
	}
}
