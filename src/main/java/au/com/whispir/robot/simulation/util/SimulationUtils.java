package au.com.whispir.robot.simulation.util;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.whispir.robot.simulation.exception.SimulationException;
import au.com.whispir.robot.simulation.model.input.TextInstructionDecoder;

/**
 * This class provides utility convenience pertaining to text manipulation and file I/O.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class SimulationUtils {	
	
	// Private constructor to prevent instantiation of the utility class.
	private SimulationUtils(){
		
	}
	
	/**
	 * Reads each line of text from the given file and 
	 * returns the lines read as a list of valid textual instructions.
	 * @param filePath
	 * @return List<String>
	 */
	public static List<String> retrieveInstructionsFromFile(String filePath) {
		// Read instructions from input file
		// and return the valid ones as a list.
		try{
			List<String> instructionList = Files.readAllLines(Paths.get(SimulationUtils.class.getClassLoader().getResource(filePath).toURI()))
												.stream()
												.map(line -> line.trim())
												.filter(line -> (!SimulationUtils.isBlankText(line) && 
																 !SimulationUtils.isCommentText(line) &&
																 TextInstructionDecoder.isValidInstruction(line)))
												.collect(toList());
			return instructionList;
		} 
		catch (NullPointerException | IOException | URISyntaxException e) {
			throw new SimulationException(CommonConstants.ERROR_READING_INSTRUCTIONS);
		}
	}
	
	/**
	 * Returns whether the given text is blank.
	 * @param text
	 * @return boolean
	 */
	public static boolean isBlankText(String text){
		return (text==null || text.trim().length()==0);
	}
	
	/**
	 * Returns if the specified text is a comment.
	 * @param text
	 * @return boolean
	 */
	public static boolean isCommentText(String text){
		return (text!=null && text.trim().startsWith(
					ConfigUtils.getInstance().getInstructionCommentPrefix()));
	}
	
	/**
	 * Returns if the specified text represents a valid integer/long.
	 * @param text
	 * @return boolean
	 */
	public static boolean isValidInteger(String text){
		try{
			String regex = CommonConstants.REGEX_INTEGER;			 
	        Pattern pattern = Pattern.compile(regex);  
	        Matcher matcher = pattern.matcher(text); 
	        
	        return matcher.matches();  
		}
		catch(Exception e){
			throw new SimulationException(CommonConstants.ERROR_PARSING_INSTRUCTIONS);
		}
	}
}
