package au.com.whispir.robot.simulation.model.input;

import au.com.whispir.robot.simulation.command.Command;
import au.com.whispir.robot.simulation.command.LeftCommand;
import au.com.whispir.robot.simulation.command.MoveCommand;
import au.com.whispir.robot.simulation.command.PlaceCommand;
import au.com.whispir.robot.simulation.command.ReportCommand;
import au.com.whispir.robot.simulation.command.RightCommand;
import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.ToyRobot;
import au.com.whispir.robot.simulation.model.output.DisplayDevice;

/**
 * An enumeration type representing the possible textual instructions.
 * Also, implements the STRATEGY pattern for constructing corresponding Command objects.
 * 
 * @author Arindam Gangopadhyay
 * 
 */
public enum InstructionType {
	PLACE {			
		public Command constructCommand(ToyRobot targetRobot, String instruction) {
			Position position = TextInstructionDecoder.parsePosition(instruction);
			return (position==null) ? null : new PlaceCommand(targetRobot, position);
		}
	}, 		
	MOVE {			
		public Command constructCommand(ToyRobot targetRobot, String instruction) {
			return new MoveCommand(targetRobot);
		}
	}, 		
	LEFT {			
		public Command constructCommand(ToyRobot targetRobot, String instruction) {
			return new LeftCommand(targetRobot);
		}
	},		
	RIGHT {			
		public Command constructCommand(ToyRobot targetRobot, String instruction) {
			return new RightCommand(targetRobot);
		}
	}, 		
	REPORT {			
		public Command constructCommand(ToyRobot targetRobot, String instruction) {
			return new ReportCommand(targetRobot, DisplayDevice.getInstance());
		}
	};		
			
	/**
	 * Defines the base command-construction method to be implemented by subtypes,
	 * thereby providing the relevant concrete algorithm details.
	 * 
	 * @param targetRobot
	 * @param instruction
	 * @return Command
	 */
	public abstract Command constructCommand(ToyRobot targetRobot, String instruction);	
}
