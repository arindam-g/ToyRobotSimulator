package au.com.whispir.robot.simulation.exception;

/**
 * An application-specific exception class for handling errors 
 * pertaining to robot-movement simulation.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class SimulationException extends RuntimeException {

	private static final long serialVersionUID = 6758435923538877227L;

	public SimulationException(String message) {
		super(message);
	}

	public SimulationException(Throwable cause) {
		super(cause);
	}

	public SimulationException(String message, Throwable cause) {
		super(message, cause);
	}

}