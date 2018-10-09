package au.com.whispir.robot.simulation.command;

import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * The command class that instructs the robot to move forward.
 * The target robot object is encapsulated within.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class MoveCommand implements Command {

	private ToyRobot target;
	
	/**
	 * Default constructor
	 * @param target
	 */
	public MoveCommand(ToyRobot target) {
		this.target = target;
	}
	
	/**
	 * The common API that triggers the command 
	 * and causes the robot to move forward.
	 */
	@Override
	public void execute() {		
		target.moveForward();
	}
}
