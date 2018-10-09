package au.com.whispir.robot.simulation.command;

import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * The command class that instructs the robot to turn left.
 * The target robot object is encapsulated within.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class LeftCommand implements Command {

	private ToyRobot target;
	
	/**
	 * Default constructor
	 * @param target
	 */
	public LeftCommand(ToyRobot target) {
		this.target = target;
	}
	
	/**
	 * The common API that triggers the command 
	 * and causes the robot to turn left.
	 */
	@Override
	public void execute() {		
		target.turnLeft();
	}
}
