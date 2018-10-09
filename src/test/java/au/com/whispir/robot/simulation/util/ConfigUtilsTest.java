package au.com.whispir.robot.simulation.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import au.com.whispir.robot.simulation.util.ConfigUtils;

/**
 * Test case for test-driving feature development of ConfigUtils.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class ConfigUtilsTest {

	@Test
	public void testInstructionsInputFilePath() {
		String value = ConfigUtils.getInstance().getInstructionInputFilePath();
		assertEquals("instruction-input.txt", value);
	}
	
	@Test
	public void testInstructionsCommentPrefix() {
		String value = ConfigUtils.getInstance().getInstructionCommentPrefix();
		assertEquals("#", value);
	}
}
