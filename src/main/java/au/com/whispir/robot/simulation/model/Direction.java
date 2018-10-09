package au.com.whispir.robot.simulation.model;

/**
 * An enumeration type representing the 4 cardinal compass points.
 * 
 * Encapsulates the states that a Direction object can be in at any given time,
 * and also defines the applicable state-transition (rotation) operations.
 * An implementation of the STATE design pattern.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public enum Direction {
	
	/*
	 * Each enumeration provides concrete implementations for the 
	 * state-transition operations, thereby returning a different 
	 * enum value as the new state.
	 */
	
	EAST {
		public Direction rotateClockwise(){
			return SOUTH;
		}
		
		public Direction rotateAntiClockwise(){
			return NORTH;
		}
	},
	
	WEST {
		public Direction rotateClockwise(){
			return NORTH;
		}
		
		public Direction rotateAntiClockwise(){
			return SOUTH;
		}
	}, 
	
	NORTH {
		public Direction rotateClockwise(){
			return EAST;
		}
		
		public Direction rotateAntiClockwise(){
			return WEST;
		}
	}, 
	
	SOUTH {
		public Direction rotateClockwise(){
			return WEST;
		}
		
		public Direction rotateAntiClockwise(){
			return EAST;
		}
	};
	
	
	/**
	 * Returns the new orientation after a clockwise rotation is performed.
	 * Note that a rotation by 90 degrees is assumed.
	 * @return Direction
	 */
	public abstract Direction rotateClockwise();
	
	/**
	 * Returns the new orientation after an anti-clockwise rotation is performed.
	 * Note that a rotation by 90 degrees is assumed.
	 * @return Direction
	 */
	public abstract Direction rotateAntiClockwise();	
}
