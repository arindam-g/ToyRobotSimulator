package au.com.whispir.robot.simulation.command;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.whispir.robot.simulation.command.LeftCommand;
import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * Test case for test-driving LeftCommand feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class LeftCommandTest {
	
	@Mock
	private ToyRobot target;
	
	private LeftCommand leftCommand;	
	
	@Before
	public void setUp() throws Exception {
		// Initialise the mock objects
		MockitoAnnotations.initMocks(this);		
		leftCommand = new LeftCommand(target);
	}
	
	@Test
	public void testExecute() {		
		leftCommand.execute();
		verify(target).turnLeft();		
	}	
}
