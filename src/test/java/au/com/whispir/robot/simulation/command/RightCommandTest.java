package au.com.whispir.robot.simulation.command;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.whispir.robot.simulation.command.RightCommand;
import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * Test case for test-driving RightCommand feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class RightCommandTest {
	
	@Mock
	private ToyRobot target;
	
	private RightCommand rightCommand;	
	
	@Before
	public void setUp() throws Exception {
		// Initialise the mock objects
		MockitoAnnotations.initMocks(this);		
		rightCommand = new RightCommand(target);
	}
	
	@Test
	public void testExecute() {		
		rightCommand.execute();
		verify(target).turnRight();		
	}	
}
