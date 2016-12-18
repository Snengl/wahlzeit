package org.wahlzeit.model;

import org.wahlzeit.model.coordinate.CoordinateDistanceException;
import org.wahlzeit.model.coordinate.CoordinateParameterException;
import org.wahlzeit.model.coordinate.SphericCoordinate;
import org.wahlzeit.model.coordinate.UnknownCoordinateException;

public class Location {

	protected SphericCoordinate coordinate;

	public Location(SphericCoordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Location(double latitude, double longitude) throws CoordinateParameterException {
		this.coordinate = SphericCoordinate.getInstance(latitude, longitude, 6371.0);
	}
	
	public Location(double latitude, double longitude, double radius) throws CoordinateParameterException {
		this.coordinate = SphericCoordinate.getInstance(latitude, longitude, radius);
	}

	public double getDistance(Location locationB)
			throws UnknownCoordinateException, CoordinateParameterException, CoordinateDistanceException {
		return coordinate.getDistance(locationB.coordinate);
	}

}
