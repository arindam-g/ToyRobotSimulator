package au.com.whispir.robot.simulation.model;

import au.com.whispir.robot.simulation.util.CommonConstants;

/**
 * The model class that represents a point in the coordinate axes.
 * A two-dimensional surface is assumed.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class Location {
	
	// For the sake of simplicity, 
	// the coordinates are kept as 'long' and not 'double'
	private long xCoordinate;
	private long yCoordinate;
	
	/**
	 * Default constructor
	 * @param xCoordinate
	 * @param yCoordinate
	 */
	public Location(long xCoordinate, long yCoordinate){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public void incrementXCoordinate() {
		xCoordinate++;
	}
	
	public void decrementXCoordinate() {
		xCoordinate--;
	}
	
	public void incrementYCoordinate() {
		yCoordinate++;
	}
	
	public void decrementYCoordinate() {
		yCoordinate--;
	}
	
	public long getXCoordinate() {
		return xCoordinate;
	}

	public long getYCoordinate() {
		return yCoordinate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (xCoordinate ^ (xCoordinate >>> 32));
		result = prime * result + (int) (yCoordinate ^ (yCoordinate >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (xCoordinate != other.xCoordinate)
			return false;
		if (yCoordinate != other.yCoordinate)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(getXCoordinate());
		sb.append(CommonConstants.STRING_COMMA).append(CommonConstants.STRING_SPACE);
		sb.append(getYCoordinate());		
		return sb.toString();		
	}
}
