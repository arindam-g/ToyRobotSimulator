package au.com.whispir.robot.simulation.model.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import au.com.whispir.robot.simulation.command.Command;
import au.com.whispir.robot.simulation.command.LeftCommand;
import au.com.whispir.robot.simulation.command.MoveCommand;
import au.com.whispir.robot.simulation.command.PlaceCommand;
import au.com.whispir.robot.simulation.command.ReportCommand;
import au.com.whispir.robot.simulation.command.RightCommand;
import au.com.whispir.robot.simulation.command.invoker.CommandController;
import au.com.whispir.robot.simulation.exception.SimulationException;
import au.com.whispir.robot.simulation.model.Direction;
import au.com.whispir.robot.simulation.model.Location;
import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.TableSurface;
import au.com.whispir.robot.simulation.model.ToyRobot;
import au.com.whispir.robot.simulation.model.input.TextInstructionDecoder;

/**
 * Test case for test-driving TextInstructionDecoder feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class TextInstructionDecoderTest {

	private List<String> instructions;	
	private CommandController commandController;
	private ToyRobot targetRobot;
	
	private TextInstructionDecoder decoder;

	@Before
	public void setUp() throws Exception {
		instructions = new ArrayList<>();
		instructions.add("PLACE 1,2,EAST");
		instructions.add("MOVE");
		instructions.add("MOVE");
		instructions.add("LEFT");
		instructions.add("MOVE");
		instructions.add("REPORT");
		
		commandController = new CommandController();		
		targetRobot = new ToyRobot(new TableSurface());
	}
	
	@Test
	public void testParseCommandSuccess() {		
		Command command = TextInstructionDecoder.parseCommand(targetRobot, "PLACE 1,2,EAST");				
		assertTrue(command instanceof PlaceCommand);
		command.execute();
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "MOVE");				
		assertTrue(command instanceof MoveCommand);
		command.execute();
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "LEFT");				
		assertTrue(command instanceof LeftCommand);
		command.execute();
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "MOVE");				
		assertTrue(command instanceof MoveCommand);
		command.execute();
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "RIGHT");				
		assertTrue(command instanceof RightCommand);
		command.execute();
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "REPORT");				
		assertTrue(command instanceof ReportCommand);
		assertEquals(targetRobot.reportCurrentPosition(), new Position(new Location(2, 3), Direction.EAST));
	}
	
	@Test
	public void testParseCommandError() {		
		Command command = TextInstructionDecoder.parseCommand(targetRobot, "PLACEERT 3,5,NORTH");		
		assertFalse(command instanceof PlaceCommand);
		assertEquals(null, command);
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "PLACE 3,5,NORTHH");		
		assertFalse(command instanceof PlaceCommand);
		assertEquals(null, command);
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "PLACE 3,5#,NORTH");		
		assertFalse(command instanceof PlaceCommand);
		assertEquals(null, command);
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "MOVEE");		
		assertFalse(command instanceof MoveCommand);
		assertEquals(null, command);
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "LEFT TURN");		
		assertFalse(command instanceof LeftCommand);
		assertEquals(null, command);
		
		command = TextInstructionDecoder.parseCommand(targetRobot, "TURN RIGHT");		
		assertFalse(command instanceof RightCommand);
		assertEquals(null, command);
	}
	
	@Test
	public void testDecodeAndRegisterSuccess() {		
		decoder = new TextInstructionDecoder(instructions, commandController, targetRobot);
		decoder.decodeAndRegister();
		
		commandController.executeCommands();
		assertEquals(targetRobot.reportCurrentPosition(), new Position(new Location(3, 3), Direction.NORTH));
	}
	
	@Test(expected = SimulationException.class)
	public void testDecodeExceptionForNullInstructions() {
		decoder = new TextInstructionDecoder(null, commandController, targetRobot);
		decoder.decodeAndRegister();
	}
	
	@Test(expected = SimulationException.class)
	public void testDecodeExceptionForNullCommandController() {
		decoder = new TextInstructionDecoder(instructions, null, targetRobot);
		decoder.decodeAndRegister();
	}
	
	@Test(expected = SimulationException.class)
	public void testDecodeExceptionForNullTargetRobot() {
		decoder = new TextInstructionDecoder(instructions, commandController, null);
		decoder.decodeAndRegister();
	}
}
