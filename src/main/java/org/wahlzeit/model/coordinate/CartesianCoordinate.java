package org.wahlzeit.model.coordinate;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CartesianCoordinate implements Coordinate {
	private static final Logger LOG = Logger.getLogger(CartesianCoordinate.class.getName());

	private double x;
	private double y;
	private double z;

	public CartesianCoordinate() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}

	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	
	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public double getDistance(Coordinate coordinate) {
		LOG.log(Level.INFO, "get distance");

		// make this method great again (next time i will use a helper class [some more beauty])
		if (coordinate instanceof SphericCoordinate) {
			return calculateDistance(convertSphericToCartesian((SphericCoordinate) coordinate));
		} else if (coordinate instanceof CartesianCoordinate) {
			return calculateDistance((CartesianCoordinate) coordinate);
		} else {
			throw new IllegalArgumentException("Unknownw coordinate type");
		}

	}

	/**
	 * Converts a spheric coordintae to a cartesian coordinate
	 * @param sphericCoordinate
	 * @return {@link CartesianCoordinate}
	 */
	public CartesianCoordinate convertSphericToCartesian(SphericCoordinate sphericCoordinate) {
		LOG.log(Level.INFO, "convert spheric coordinate to cartesian coordinate");

		CartesianCoordinate cartesianCoordinate = new CartesianCoordinate();

		double x = sphericCoordinate.radius * Math.cos(sphericCoordinate.latitude);
		double y = sphericCoordinate.radius * Math.sin(sphericCoordinate.longitude);

		cartesianCoordinate.setX(x);
		cartesianCoordinate.setY(y);

		return cartesianCoordinate;
	}

	/**
	 * 
	 * @param cartesianCoordinate
	 * @return distance
	 */
	public double calculateDistance(CartesianCoordinate otherCoordinate) {
		LOG.log(Level.INFO, "calculate cartesian distance");

		/*
		 * Formula and additional information: https://en.wikipedia.org/w/index.php?title=Distance&oldid=747860001
		 */
		
		double deltaX = Math.pow(otherCoordinate.getX() - x, 2);
		double deltaY = Math.pow(otherCoordinate.getY() - y, 2);
		double deltaZ = Math.pow(otherCoordinate.getZ() - z, 2);

		return Math.sqrt(deltaX * deltaY * deltaZ);
	}

}
