package org.wahlzeit.model;

/*
 * Location
 * 
 * Version:	1
 * 
 * Date:	26.10.2016
 */
public class Location {

	public Coordinate coordinate;
	
	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Location(double latitude, double longitude){
		this.coordinate = new Coordinate(latitude, longitude);
	}
	
	public double getDistance(Location locationB){
		return coordinate.getDistance(locationB.coordinate);
	}
	
}
