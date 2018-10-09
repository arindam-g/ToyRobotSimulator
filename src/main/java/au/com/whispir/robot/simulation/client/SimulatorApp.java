package au.com.whispir.robot.simulation.client;

import java.util.List;

import au.com.whispir.robot.simulation.command.invoker.CommandController;
import au.com.whispir.robot.simulation.model.TableSurface;
import au.com.whispir.robot.simulation.model.ToyRobot;
import au.com.whispir.robot.simulation.model.input.TextInstructionDecoder;
import au.com.whispir.robot.simulation.util.ConfigUtils;
import au.com.whispir.robot.simulation.util.SimulationUtils;

/**
 * A sample client that provides an entry point to the 
 * Toy Robot Simulator application.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class SimulatorApp {
	
	/**
	 * Triggers the execution of the simulator application.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SimulatorApp toyRobotSimulator = new SimulatorApp();	
		toyRobotSimulator.simulate();
	}
	
	/*
	 * An end-to-end method for performing an example simulation.
	 */
	private void simulate() throws Exception {
		// Retrieve instructions from an input file
		List<String> instructions = SimulationUtils.retrieveInstructionsFromFile(
											ConfigUtils.getInstance().getInstructionInputFilePath());		
		
		// Initialise the ToyRobot with TableSurface information
		ToyRobot robot = new ToyRobot(new TableSurface());
		CommandController controller = new CommandController();
		
		// Set up a new instruction decoder with details about
		// the text instructions, the robot and the command controller.		
		// The decoder parses the instructions into commands for the robot
		// and registers them with the command controller for execution
		// ("client" in the COMMAND pattern).
		new TextInstructionDecoder(instructions, controller, robot).decodeAndRegister();
		
		// The command controller triggers the seamless execution of the commands
		// ("invoker" in the COMMAND pattern).
		controller.executeCommands();
	}
}
