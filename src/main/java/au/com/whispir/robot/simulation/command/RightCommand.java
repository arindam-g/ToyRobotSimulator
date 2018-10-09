package au.com.whispir.robot.simulation.command;

import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * The command class that instructs the robot to turn right.
 * The target robot object is encapsulated within.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class RightCommand implements Command {

	private ToyRobot target;
	
	/**
	 * Default constructor
	 * @param target
	 */
	public RightCommand(ToyRobot target) {
		this.target = target;
	}
	
	/**
	 * The common API that triggers the command 
	 * and causes the robot to turn right.
	 */
	@Override
	public void execute() {		
		target.turnRight();
	}	
}
