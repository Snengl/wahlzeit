package org.wahlzeit.model.coordinate;

public interface Coordinate {

	/**
	 * @methodtype query
	 * @param coordinate
	 * @return distance in kilometer
	 * @throws CoordinateDistanceException 
	 */
	public double getDistance(Coordinate otherCoordinate) throws UnknownCoordinateException, CoordinateParameterException, CoordinateDistanceException;
	
	public boolean isEqual(Coordinate otherCoordinate) throws UnknownCoordinateException, CoordinateParameterException;

	public CartesianCoordinate asCartesianCoordinate() throws CoordinateParameterException;
}
