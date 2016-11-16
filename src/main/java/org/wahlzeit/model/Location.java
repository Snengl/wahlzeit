package org.wahlzeit.model;

import org.wahlzeit.model.coordinate.SphericCoordinate;

public class Location {

	protected SphericCoordinate coordinate;

	public Location(SphericCoordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Location(double latitude, double longitude) {
		this.coordinate = new SphericCoordinate(latitude, longitude, 6371.0);
	}

	public double getDistance(Location locationB) {
		return coordinate.getDistance(locationB.coordinate);
	}

}
