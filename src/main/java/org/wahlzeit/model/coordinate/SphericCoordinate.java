package org.wahlzeit.model.coordinate;

public class SphericCoordinate extends AbstractCoordiante {
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
			throw new IllegalArgumentException("BadumTss: Bad longitude.");
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
			throw new IllegalArgumentException("BadumTss: Bad longitude.");
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
	public CartesianCoordinate asCartesianCoordinate() {
		
		/*
		 * Formula and additional information:
		 * https://en.wikipedia.org/w/index.php?title=Spherical_coordinate_system&oldid=748510862
		 */
		
		CartesianCoordinate cartesianCoordinate = new CartesianCoordinate();

		double x = radius * Math.sin(Math.toRadians(longitude)) * Math.cos(Math.toRadians(latitude));
		double y = radius * Math.sin(Math.toRadians(longitude)) * Math.sin(Math.toRadians(latitude));
		double z = radius * Math.cos(Math.toRadians(longitude));

		cartesianCoordinate.setX(x);
		cartesianCoordinate.setY(y);
		cartesianCoordinate.setZ(z);

		return cartesianCoordinate;
	}

}
