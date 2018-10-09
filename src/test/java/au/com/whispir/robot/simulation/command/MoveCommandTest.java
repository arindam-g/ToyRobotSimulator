package au.com.whispir.robot.simulation.command;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.whispir.robot.simulation.command.MoveCommand;
import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * Test case for test-driving MoveCommand feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class MoveCommandTest {
	
	@Mock
	private ToyRobot target;
	
	private MoveCommand moveCommand;	
	
	@Before
	public void setUp() throws Exception {
		// Initialise the mock objects
		MockitoAnnotations.initMocks(this);		
		moveCommand = new MoveCommand(target);
	}
	
	@Test
	public void testExecute() {		
		moveCommand.execute();
		verify(target).moveForward();		
	}	
}
