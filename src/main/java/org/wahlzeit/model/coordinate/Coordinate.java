package org.wahlzeit.model.coordinate;

public interface Coordinate {

	/**
	 * 
	 * @param coordinate
	 * @return distance in kilometer
	 */
	public double getDistance(Coordinate otherCoordinate);
	
	public boolean isEqual(Coordinate otherCoordinate);

	public CartesianCoordinate asCartesianCoordinate();
}
