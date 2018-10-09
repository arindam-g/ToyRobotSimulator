package au.com.whispir.robot.simulation.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import au.com.whispir.robot.simulation.exception.SimulationException;
import au.com.whispir.robot.simulation.util.ConfigUtils;
import au.com.whispir.robot.simulation.util.SimulationUtils;

/**
 * Test case for test-driving SimulationUtils feature development.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class SimulationUtilsTest {

	@Test
	public void testRetrieveInstructionsFromFileSuccess() {	
		List<String> instructions = SimulationUtils.retrieveInstructionsFromFile(
											ConfigUtils.getInstance().getInstructionInputFilePath());
		assertEquals(21, instructions.size());
		assertEquals("PLACE 1,2,EAST", instructions.get(6));		
		assertFalse(instructions.contains("# Expected Output: 5,4,SOUTH"));	
	}
	
	@Test(expected = SimulationException.class)
	public void testRetrieveInstructionsFromFileError() {	
		SimulationUtils.retrieveInstructionsFromFile("resources/no-file.txt");
	}
	
	@Test
	public void testIsValidInteger() {	
		assertTrue(SimulationUtils.isValidInteger("12"));
		assertTrue(SimulationUtils.isValidInteger("01200"));
		assertTrue(SimulationUtils.isValidInteger(" 012\t ".trim()));
		
		assertFalse(SimulationUtils.isValidInteger(" 12\t "));
		assertFalse(SimulationUtils.isValidInteger("7.54"));		
		assertFalse(SimulationUtils.isValidInteger("Text"));		
	}
	
	@Test
	public void testIsBlankText() {	
		assertTrue(SimulationUtils.isBlankText(" \t  "));
		assertFalse(SimulationUtils.isBlankText(" .  "));		
	}
	
	@Test
	public void testIsCommentText() {	
		assertTrue(SimulationUtils.isCommentText(" # Comments  "));
		assertFalse(SimulationUtils.isCommentText(" Comments  "));		
	}
}
