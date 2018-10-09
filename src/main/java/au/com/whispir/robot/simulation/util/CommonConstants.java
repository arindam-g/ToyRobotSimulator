package au.com.whispir.robot.simulation.util;

/**
 * The class provides a common place for constant values
 * required within the application.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class CommonConstants {
		
	// Private constructor to prevent instantiation of the class.
	private CommonConstants(){
		
	}
	
	/*
	 * General constants
	 */
	public static final String STRING_SPACE = " ";	
	
	public static final String STRING_COMMA = ",";
	
	public static final String REGEX_INTEGER = "[0-9]*";
	
	
		
	/*
	 * Error messages
	 */
	public static final String ERROR_PARSING_INSTRUCTIONS = "Error encountered in parsing text instructions";
	
	public static final String ERROR_READING_INSTRUCTIONS = "Error reading instructions from input file";
	
	public static final String INSTRUCTIONS_NOT_AVAILABLE = "Instructions not available";	
	
	public static final String COMMAND_CONTROLLER_NOT_CONFIGURED = "No command controller is configured";	
	
	public static final String NO_TARGET_ROBOT = "Information missing for target robot";
}
