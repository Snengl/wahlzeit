package org.wahlzeit.model.coordinate;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.wahlzeit.model.coordinate.Coordinate;

public class SphericCoordinate implements Coordinate {
	private static final Logger LOG = Logger.getLogger(SphericCoordinate.class.getName());

	protected double latitude;
	protected double longitude;
	protected double radius;

	public SphericCoordinate() {
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.radius = 0.0;
	}

	public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException {
		if (latitude < -90 || latitude > 90 || Double.isNaN(latitude)) {
			throw new IllegalArgumentException("BadumTss: Bad latitude.");
		}
		if (longitude < -180 || longitude > 180 || Double.isNaN(longitude)) {
			throw new IllegalArgumentException("BaumTss: Bad longitude.");
		}
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		if (latitude < -90 || latitude > 90 || Double.isNaN(latitude)) {
			throw new IllegalArgumentException("BadumTss: Bad latitude.");
		}
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		if (longitude < -180 || longitude > 180 || Double.isNaN(longitude)) {
			throw new IllegalArgumentException("BaumTss: Bad longitude.");
		}
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	// make this method great again (next time i will use a helper class [some more beauty])
	public double getDistance(Coordinate coordinate) {
		LOG.log(Level.INFO, "get distance");

		if (coordinate instanceof CartesianCoordinate) {
			CartesianCoordinate coordinateA = new CartesianCoordinate();
			coordinateA.convertSphericToCartesian(new SphericCoordinate(this.latitude, this.longitude, this.radius));
			return coordinateA.calculateDistance((CartesianCoordinate) coordinate);
		} else if (coordinate instanceof SphericCoordinate) {
			return calculateDistance((SphericCoordinate) coordinate);
		} else {
			throw new IllegalArgumentException("Unknownw coordinate type");
		}

	}

	/**
	 * 
	 * @param sphericCoordinate
	 * @return distance
	 */
	public double calculateDistance(SphericCoordinate otherCoordinate) {
		LOG.log(Level.INFO, "calculate spheric distance");

		/*
		 * Orthodrome: The shortest distance between two points on a sphere.
		 * Formula and additional information:
		 * https://de.wikipedia.org/w/index.php?title=Orthodrome&oldid=156893549
		 */

		double phiA = Math.toRadians(latitude);
		double lamdaA = Math.toRadians(longitude);
		double phiB = Math.toRadians(otherCoordinate.latitude);
		double lambdaB = Math.toRadians(otherCoordinate.longitude);

		double distance = radius * Math
				.acos(Math.sin(phiA) * Math.sin(phiB) + (Math.cos(phiA) * Math.cos(phiB) * Math.cos(lamdaA - lambdaB)));

		return distance;
	}

}
