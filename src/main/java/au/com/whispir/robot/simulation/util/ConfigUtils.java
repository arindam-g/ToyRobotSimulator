package au.com.whispir.robot.simulation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Convenience class for retrieving configured application properties
 * through simple APIs.
 * 
 * @author Arindam Gangopadhyay
 * 
 */
public class ConfigUtils {
	
	private static final Logger LOGGER = Logger.getLogger(ConfigUtils.class.getName());
	
	private Properties properties;
	private static final String CONFIG_FILE = "config/simulation.properties";
	
	/*
	 * SINGLETON instance of this class.
	 */
	private static ConfigUtils instance = new ConfigUtils();
	
	/*
	 * Private constructor for preventing public instantiation.
	 */
	private ConfigUtils(){		
		properties = new Properties();
		File configFile = null;
		try {
			configFile = new File(CONFIG_FILE);			
	        properties.load(new FileInputStream(configFile));
        }		
        catch(IOException e) {           
        	LOGGER.log(Level.SEVERE, "No property file found at: " + configFile.getAbsolutePath());        	
        }		
	}	
	
	/**
	 * Returns a singleton object of this class.
	 * @return ConfigUtils
	 */
	public static ConfigUtils getInstance(){		
		return instance;
	}
	
	/**
	 * Returns the configured path for the input data file
	 * @return String
	 */
	public String getInstructionInputFilePath(){
		return properties.getProperty("instruction.input.filepath").trim();
	}
	
	/**
	 * Returns the configured prefix for identifying a line of input as comment
	 * @return String
	 */
	public String getInstructionCommentPrefix(){
		return properties.getProperty("instruction.comment.prefix").trim();
	}
}
