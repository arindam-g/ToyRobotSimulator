package au.com.whispir.robot.simulation.model;

import au.com.whispir.robot.simulation.model.factory.MovementResolverFactory;
import au.com.whispir.robot.simulation.util.CommonConstants;

/**
 * A model representing a directed point in the 2D coordinate axes.
 * It is a FACADE class that encapsulates interfaces for Location and Direction.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class Position {

	private Location location;
	private Direction orientation;
	
	/**
	 * Default constructor
	 * @param location
	 * @param orientation
	 */
	public Position(Location location, Direction orientation){
		this.location = location;
		this.orientation = orientation;
	}
	
	/**
	 * Rotates the orientation in a clockwise direction.
	 * The location remains unchanged.
	 */
	public void rotateOrientationClockwise(){
		orientation = orientation.rotateClockwise();
	}
	
	/**
	 * Rotates the orientation in an anti-clockwise direction.
	 * The location remains unchanged.
	 */
	public void rotateOrientationAntiClockwise(){
		orientation = orientation.rotateAntiClockwise();
	}
	
	/**
	 * Moves the location forward in the current direction, by single unit.
	 * The orientation remains unchanged.
	 */
	public void advanceLocationByUnitStep(){
		// Delegate to an appropriate movement-resolver (obtained via a factory)
		// for advancing the current location in the current orientation.
		MovementResolverFactory.getDirectedMovementResolver(orientation).advanceByUnitStep(location);
	}
	
	public Direction getOrientation() {
		return orientation;
	}

	public Location getLocation() {
		return location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((orientation == null) ? 0 : orientation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (orientation != other.orientation)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(location.toString());		
		sb.append(CommonConstants.STRING_COMMA).append(CommonConstants.STRING_SPACE);
		sb.append(orientation.toString());
		return sb.toString();		
	}
}
