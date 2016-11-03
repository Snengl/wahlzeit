package org.wahlzeit.model;

public class Location {

	protected Coordinate coordinate;

	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Location(double latitude, double longitude) {
		this.coordinate = new Coordinate(latitude, longitude);
	}

	public double getDistance(Location locationB) {
		return coordinate.getDistance(locationB.coordinate);
	}

}
