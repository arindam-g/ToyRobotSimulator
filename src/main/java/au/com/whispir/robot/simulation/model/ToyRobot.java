package au.com.whispir.robot.simulation.model;

/**
 * This model class represents a toy robot object.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class ToyRobot {

	// The current position information of the robot
	private Position currentPosition;
	
	// The surface on which the robot navigates
	private TableSurface surface;		
	
	/**
	 * Default constructor that assigns a navigation surface to the robot
	 * @param navigationSurface
	 */
	public ToyRobot(TableSurface navigationSurface){
		this.surface = navigationSurface;		
	}
	
	/**
	 * Simulates the moving of the robot by one step in the current direction.
	 */
	public void moveForward(){
		// The robot does NOT move forward if it does not yet have a valid current position,
		// or if it finds itself at an edge of the navigation surface prior to moving.
		// The robot's orientation is taken into account to see if there's room in "front" of it for moving.		
		if(currentPosition != null &&
		   !surface.isPositionOnSurfaceEdge(currentPosition)){
			
			// There's no need to verify the validity of the new position
			// as the robot always makes 'unit' movement and the surface has 'long' coordinates.
			currentPosition.advanceLocationByUnitStep();		
		}
	}

	/**
	 * Simulates the turning of the robot to the left by 90 degrees, 
	 * without changing its position.
	 */
	public void turnLeft(){
		// The robot ignores this action if it does not yet have a valid current position.
		if(currentPosition != null){
			currentPosition.rotateOrientationAntiClockwise();
		}
	}
	
	/**
	 * Simulates the turning of the robot to the right by 90 degrees, 
	 * without changing its position.
	 */
	public void turnRight(){
		// The robot ignores this action if it does not yet have a valid current position.
		if(currentPosition != null){
			currentPosition.rotateOrientationClockwise();
		}
	}

	/**
	 * Places (re-positions) the robot to the given position (location & orientation).
	 * @param position
	 */
	public void placeAtPosition(Position position) {		
		// The robot makes sure the new position is valid, before being placed there.
		if(surface.isPositionValidOnSurface(position)){
			currentPosition = position;
		}
	}	

	/**
	 * Reports (returns) the current position information of the robot.
	 * @return Position
	 */
	public Position reportCurrentPosition() {		
		return currentPosition;			
	}
}
