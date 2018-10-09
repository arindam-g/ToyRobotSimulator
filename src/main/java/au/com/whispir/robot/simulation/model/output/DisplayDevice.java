package au.com.whispir.robot.simulation.model.output;

/**
 * A simple class representing an output device for displaying data.
 * The current implementation prints to the system console.
 * 
 * @author Arindam Gangopadhyay
 * 
 */
public class DisplayDevice {

	/*
	 * SINGLETON instance of this class.
	 */
	private static DisplayDevice instance = new DisplayDevice();
	
	/*
	 * Private constructor for preventing public instantiation.
	 */
	private DisplayDevice(){		
		
	}	
	
	/**
	 * Returns a singleton object of this class.
	 * @return DisplayDevice
	 */
	public static DisplayDevice getInstance(){		
		return instance;
	}
	
	/**
	 * Prints the given data to the system console.
	 * @param outputText
	 */
	public void printToConsole(Object data){
		System.out.println(data);
	}
}
