package au.com.whispir.robot.simulation.command;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.whispir.robot.simulation.command.ReportCommand;
import au.com.whispir.robot.simulation.model.Position;
import au.com.whispir.robot.simulation.model.ToyRobot;
import au.com.whispir.robot.simulation.model.output.DisplayDevice;

/**
 * Test case for test-driving ReportCommand feature development.
 * 
 * @author Arindam Gangopadhyay
 * 
 */
public class ReportCommandTest {

	@Mock
	private ToyRobot target;
	@Mock
	private DisplayDevice displayDevice;
	@Mock
	private Position robotPosition;

	private ReportCommand reportCommand;
	
	@Before
	public void setUp() throws Exception {
		// Initialise the mock objects
		MockitoAnnotations.initMocks(this);
		reportCommand = new ReportCommand(target, displayDevice);
	}

	@Test
	public void testExecute() {
		when(target.reportCurrentPosition()).thenReturn(robotPosition);
		reportCommand.execute();
		
		verify(target).reportCurrentPosition();
		verify(displayDevice).printToConsole(robotPosition);
	}
}
