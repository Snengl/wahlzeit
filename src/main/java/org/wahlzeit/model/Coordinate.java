package org.wahlzeit.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Coordinate
 * 
 * Version:	1
 * 
 * Date:	26.10.2016
 */
public class Coordinate {

	private static final Logger LOG = Logger.getLogger(Coordinate.class.getName());
	private static final double EARTH_KM_RADIUS = 6731.0;

	private double latitude;
	private double longitude;

	public Coordinate() {
		latitude = 0.0;
		longitude = 0.0;
	}

	public Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	// returns distance in kilometer
	public double getDistance(Coordinate coordinateB) {

		/*
		 * Orthodrome: The shortest distance between two points on a sphere.
		 * 
		 * Formular:
		 * 
		 * Distance = Radius * acos(sin(phiA) * sin(phiB) + cos(phiA) *
		 * cos(phiB) * cos(lamdaA - lamdaB)
		 */

		double phiA = Math.toRadians(latitude);
		double lamdaA = Math.toRadians(longitude);

		double phiB = Math.toRadians(coordinateB.latitude);
		double lambdaB = Math.toRadians(coordinateB.longitude);

		double distance = EARTH_KM_RADIUS * Math
				.acos(Math.sin(phiA) * Math.sin(phiB) + (Math.cos(phiA) * Math.cos(phiB) * Math.cos(lamdaA - lambdaB)));

		LOG.log(Level.INFO, "Distance: " + String.valueOf(distance));

		return distance;
	}

}
