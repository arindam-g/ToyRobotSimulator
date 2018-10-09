package au.com.whispir.robot.simulation.model.input;

import java.util.List;

import au.com.whispir.robot.simulation.command.Command;
import au.com.whispir.robot.simulation.command.invoker.CommandController;
import au.com.whispir.robot.simulation.exception.SimulationException;
import au.com.whispir.robot.simulation.model.Direction;
import au.com.whispir.robot.simulation.model.Location;
import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.ToyRobot;
import au.com.whispir.robot.simulation.util.CommonConstants;
import au.com.whispir.robot.simulation.util.SimulationUtils;

/**
 * The class represents a parser that can "decode" text-format instructions, 
 * and "transform" them into Command objects that are legible to the robots.
 * Also, shares the responsibility of the "client" in the COMMAND pattern.
 *  
 * @author Arindam Gangopadhyay
 *
 */
public class TextInstructionDecoder {

	private List<String> instructions;	
	private CommandController commandController;
	private ToyRobot targetRobot;
	
	/**
	 * Default constructor
	 * @param instructions
	 */
	public TextInstructionDecoder(List<String> instructions, 
							  CommandController commandController, 
							  ToyRobot targetRobot){		
		this.instructions = instructions;
		this.commandController = commandController;
		this.targetRobot = targetRobot;
	}
	
	/**
	 * Decodes the instruction list into Command objects
	 * and registers them with the command-controller for execution.
	 * Shares the responsibility of the "client" in the COMMAND pattern.
	 * 
	 * @throws SimulationException
	 */
	public void decodeAndRegister() throws SimulationException{
		if(this.instructions==null){
			throw new SimulationException(CommonConstants.INSTRUCTIONS_NOT_AVAILABLE);
		}
		else if(this.commandController==null){
			throw new SimulationException(CommonConstants.COMMAND_CONTROLLER_NOT_CONFIGURED);
		}
		else if(this.targetRobot==null){
			throw new SimulationException(CommonConstants.NO_TARGET_ROBOT);
		}
		
		// Decode the instructions, and register the corresponding commands
		this.instructions.stream()
						 .map(instruction -> TextInstructionDecoder.parseCommand(targetRobot, instruction))
						 .filter(command -> command != null)
						 .forEach(command -> this.commandController.registerCommand(command));	
	}
	
	/**
	 * Returns a concrete subclass of Command corresponding to the instruction-type.
	 * Returns null if the instruction string is not valid.
	 * @param targetRobot
	 * @param instruction
	 * @return Command
	 */
	public static Command parseCommand(ToyRobot targetRobot, String instruction){
		try{
			if(isValidInstruction(instruction)){
				String instructionName = instruction.split(CommonConstants.STRING_SPACE)[0];
				return InstructionType.valueOf(instructionName)
							.constructCommand(targetRobot, instruction);
			}
			return null;
		}
		catch(SimulationException se){
			return null;
		}	
	}
	
	/**
	 * Parses the given instruction to return the position.
	 * @param instruction
	 * @return Position
	 */
	protected static Position parsePosition(String instruction){
		try{
			if(isValidPlaceInstruction(instruction)){
				String[] arguments = instruction.replace(CommonConstants.STRING_COMMA, CommonConstants.STRING_SPACE)
												.split(CommonConstants.STRING_SPACE);					
				if(arguments[3] != null){
					Direction direction = Direction.valueOf(arguments[3].trim().toUpperCase()); 					
					Position position = new Position(new Location(
							Long.parseLong(arguments[1]), Long.parseLong(arguments[2])), 
							direction);					
					return position;
				}
			}
			return null;			
		}
		catch(Exception e){
			throw new SimulationException(CommonConstants.ERROR_PARSING_INSTRUCTIONS);
		}		
	}
	
	/**
	 * Returns whether the given text is a valid instruction.
	 * @param text
	 * @return boolean
	 */
	public static boolean isValidInstruction(String text){
		try{
			if(text != null && 
					(isValidPlaceInstruction(text) || 
						InstructionType.valueOf(text.trim().toUpperCase()) != null)){			
				return true;
			}		
			return false;
		}
		catch(IllegalArgumentException iae){
			return false;
		}
		catch(Exception e){
			throw new SimulationException(CommonConstants.ERROR_PARSING_INSTRUCTIONS);
		}
	}
	
	/**
	 * Returns whether the given text represents a valid PLACE instruction.
	 * @param text
	 * @return boolean
	 */
	protected static boolean isValidPlaceInstruction(String text){
		try{
			text = text.replace(CommonConstants.STRING_COMMA, CommonConstants.STRING_SPACE);
			String[] textElements = text.split(CommonConstants.STRING_SPACE);
			
			if(textElements!=null && textElements.length==4 &&
			   textElements[0].equals(InstructionType.PLACE.toString()) &&
			   SimulationUtils.isValidInteger(textElements[1]) && SimulationUtils.isValidInteger(textElements[2]) &&
			   Direction.valueOf(textElements[3].trim().toUpperCase()) != null){
				
				return true;
			}		
			return false;
		}
		catch(IllegalArgumentException iae){
			return false;
		}
		catch(Exception e){
			throw new SimulationException(CommonConstants.ERROR_PARSING_INSTRUCTIONS);
		}
	}
}
