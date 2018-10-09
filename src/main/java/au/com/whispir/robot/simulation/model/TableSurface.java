package au.com.whispir.robot.simulation.model;

/**
 * A model class representing a simple table surface.
 * 
 * @author Arindam Gangopadhyay
 *
 */
public class TableSurface {
	/*
	 * It is assumed that the surface is 2-dimensional and flat.
	 * The table-surface has been defined to be square (5 units x 5 units),
	 * with the south-west most corner being at (0, 0).
	 * Thus, the first quadrant of coordinate axes is assumed.
	 * 
	 */
	
	private Location southWestCorner;
	private Location northEastCorner;
	
	/**
	 * Default constructor
	 */
	public TableSurface(){
		this.southWestCorner = new Location(0, 0);
		this.northEastCorner = new Location(5, 5);
	}
	
	/**
	 * Returns whether the given Position is valid on this surface.
	 * @param position
	 * @return boolean
	 */
	public boolean isPositionValidOnSurface(Position position){
		return position!=null && 
				position.getOrientation()!=null && position.getLocation()!=null && 
				this.isLocationValidOnSurface(position.getLocation());	
	}	
	
	/*
	 * Returns whether the given Location is valid on this surface.
	 * @param location
	 * @return boolean
	 */
	private boolean isLocationValidOnSurface(Location location){
		if(location==null ||
				location.getXCoordinate() < this.getSouthWestCorner().getXCoordinate() ||
				location.getYCoordinate() < this.getSouthWestCorner().getYCoordinate() || 
				location.getXCoordinate() > this.getNorthEastCorner().getXCoordinate() ||
				location.getYCoordinate() > this.getNorthEastCorner().getYCoordinate() ){
			
			return false;
		}			
		return true;		
	}
	
	/**
	 * Returns whether the given Position is on the edge of this surface. 
	 * @param position
	 * @return boolean
	 */
	public boolean isPositionOnSurfaceEdge(Position position){
		if(this.isPositionValidOnSurface(position) &&
		  ((position.getLocation().getXCoordinate() == this.getSouthWestCorner().getXCoordinate() &&
			position.getOrientation().equals(Direction.WEST)) ||
		   (position.getLocation().getYCoordinate() == this.getSouthWestCorner().getYCoordinate() &&
			position.getOrientation().equals(Direction.SOUTH)) || 
		   (position.getLocation().getXCoordinate() == this.getNorthEastCorner().getXCoordinate() &&
			position.getOrientation().equals(Direction.EAST)) ||
		   (position.getLocation().getYCoordinate() == this.getNorthEastCorner().getYCoordinate() &&
			position.getOrientation().equals(Direction.NORTH)))){
			
			return true;
		}		
		return false;
	}
	
	/**
	 * Returns the location information for the 
	 * south-west (bottom-left) corner of the surface
	 * @return Location
	 */
	public Location getSouthWestCorner() {
		return southWestCorner;
	}	
	
	/**
	 * Returns the location information for the 
	 * north-east (top-right) corner of the surface
	 * @return Location
	 */
	public Location getNorthEastCorner() {
		return northEastCorner;
	}
}
