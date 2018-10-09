package au.com.whispir.robot.simulation.command;

/**
 * The base interface that provides the command API.
 * The super-type for concrete "command" objects of the COMMAND design pattern.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public interface Command {
	
	public void execute();
}
