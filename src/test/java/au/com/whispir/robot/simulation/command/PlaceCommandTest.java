package au.com.whispir.robot.simulation.command;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.whispir.robot.simulation.command.PlaceCommand;
import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.ToyRobot;

/**
 * Test case for test-driving PlaceCommand feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class PlaceCommandTest {
	
	@Mock
	private ToyRobot target;
	
	@Mock
	private Position targetPosition;
	
	private PlaceCommand placeCommand;	
	
	@Before
	public void setUp() throws Exception {
		// Initialise the mock objects
		MockitoAnnotations.initMocks(this);		
		placeCommand = new PlaceCommand(target, targetPosition);
	}
	
	@Test
	public void testExecute() {		
		placeCommand.execute();
		verify(target).placeAtPosition(targetPosition);	
	}	
}
