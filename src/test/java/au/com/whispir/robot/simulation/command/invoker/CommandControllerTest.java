package au.com.whispir.robot.simulation.command.invoker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.whispir.robot.simulation.command.Command;
import au.com.whispir.robot.simulation.command.LeftCommand;
import au.com.whispir.robot.simulation.command.MoveCommand;
import au.com.whispir.robot.simulation.command.PlaceCommand;
import au.com.whispir.robot.simulation.command.RightCommand;
import au.com.whispir.robot.simulation.command.invoker.CommandController;
import au.com.whispir.robot.simulation.model.Direction;
import au.com.whispir.robot.simulation.model.Location;
import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.TableSurface;
import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * Test case for test-driving CommandController feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class CommandControllerTest {
	
	@Mock
	private Command command;
	
	private CommandController controller;		
	
	@Before
	public void setUp() throws Exception {		
		// Initialise the mock objects
		MockitoAnnotations.initMocks(this);		
		controller = new CommandController();		
	}	
		
	@Test
	public void testExecutionUnit() {	
		controller.registerCommand(command);
		controller.registerCommand(command);
		controller.registerCommand(command);
		
		controller.executeCommands();
		verify(command, times(3)).execute();
	}
	
	@Test
	public void testExecutionIntegration() {
		ToyRobot robot = new ToyRobot(new TableSurface());
		
		Command command = new PlaceCommand(robot, new Position(new Location(3, 3), Direction.NORTH));
		controller.registerCommand(command);
		
		command = new MoveCommand(robot);
		controller.registerCommand(command);
		
		command = new LeftCommand(robot);
		controller.registerCommand(command);
		
		command = new MoveCommand(robot);
		controller.registerCommand(command);
		
		command = new RightCommand(robot);
		controller.registerCommand(command);
		
		command = new RightCommand(robot);
		controller.registerCommand(command);
		
		controller.executeCommands();
		assertEquals(robot.reportCurrentPosition(), new Position(new Location(2, 4), Direction.EAST));
	}
}
