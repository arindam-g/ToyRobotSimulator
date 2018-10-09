package au.com.whispir.robot.simulation.command;

import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.ToyRobot;
import au.com.whispir.robot.simulation.model.output.DisplayDevice;

/**
 * The command class that instructs the robot to report its position.
 * The target robot object is encapsulated within.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class ReportCommand implements Command {

	private ToyRobot target;
	private DisplayDevice displayDevice;
	
	/**
	 * Default constructor
	 * @param target
	 * @param displayDevice
	 */
	public ReportCommand(ToyRobot target, DisplayDevice displayDevice) {
		this.target = target;
		this.displayDevice = displayDevice;
	}
	
	/**
	 * The common API that triggers the command 
	 * and causes the robot to report/print its position.
	 */
	@Override
	public void execute() {
		Position robotPosition = target.reportCurrentPosition();
		if(robotPosition != null){
			// Print robot's reported position to the display-device console
			displayDevice.printToConsole(robotPosition);
		}
	}
}
