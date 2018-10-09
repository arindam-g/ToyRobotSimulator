package au.com.whispir.robot.simulation.command.invoker;

import java.util.ArrayList;
import java.util.List;

import au.com.whispir.robot.simulation.command.Command;

/**
 * A device that has the capability to control and execute a list of commands.
 * Performs the role of "invoker" in the COMMAND pattern.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class CommandController {

	private List<Command> commands = new ArrayList<>();
	
	/**
	 * Adds the given command to its list of registered commands
	 * @param command
	 */
	public void registerCommand(Command command){
		commands.add(command);
	}
	
	/**
	 * Executes all commands one after the other
	 */
	public void executeCommands(){
		this.commands.forEach(command -> command.execute());
	}
}
