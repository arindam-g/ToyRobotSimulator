package au.com.whispir.robot.simulation.command;

import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * The command class that instructs the robot to place itself at a new position.
 * The target robot object and position details are encapsulated within.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class PlaceCommand implements Command {

	private ToyRobot target;
	private Position targetPosition;
	
	/**
	 * Default constructor
	 * @param target
	 * @param targetPosition
	 */
	public PlaceCommand(ToyRobot target, Position targetPosition){
		this.target = target;
		this.targetPosition = targetPosition;
	}
	
	/**
	 * The common API that triggers the command 
	 * and causes the robot to place itself at the given position.
	 */
	@Override
	public void execute() {		
		target.placeAtPosition(targetPosition);
	}	
}
