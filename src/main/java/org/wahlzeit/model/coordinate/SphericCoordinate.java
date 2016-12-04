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

		// preconditions
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);

		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;

		// postcondition
		assertClassInvariants();
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		// precondition
		assertIsValidLatitude(latitude);

		this.latitude = latitude;

		// postcondition
		assertClassInvariants();
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		// precondition
		assertIsValidLongitude(longitude);

		this.longitude = longitude;

		// postcondition
		assertClassInvariants();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		// precondition
		assertIsValidRadius(radius);

		this.radius = radius;

		// postcondition
		assertClassInvariants();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {

		/*
		 * Formula and additional information:
		 * https://en.wikipedia.org/w/index.php?title=Spherical_coordinate_system&oldid=748510862
		 */

		// preconditions
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);

		CartesianCoordinate cartesianCoordinate = new CartesianCoordinate();

		double x = radius * Math.sin(Math.toRadians(longitude)) * Math.cos(Math.toRadians(latitude));
		double y = radius * Math.sin(Math.toRadians(longitude)) * Math.sin(Math.toRadians(latitude));
		double z = radius * Math.cos(Math.toRadians(longitude));

		cartesianCoordinate.setX(x);
		cartesianCoordinate.setY(y);
		cartesianCoordinate.setZ(z);

		cartesianCoordinate.assertClassInvariants();

		return cartesianCoordinate;
	}

	/**
	 * @methodtype assertion
	 */
	private void assertIsValidLatitude(double latitude) {
		if (latitude < -90 || latitude > 90 || Double.isNaN(latitude)) {
			throw new IllegalArgumentException("BadumTss: Bad latitude.");
		}
	}

	/**
	 * @methodtype assertion
	 */
	private void assertIsValidLongitude(double longitude) {
		if (longitude < -180 || longitude > 180 || Double.isNaN(longitude)) {
			throw new IllegalArgumentException("BadumTss: Bad longitude.");
		}
	}

	/**
	 * @methodtype assertion
	 */
	private void assertIsValidRadius(double radius) {
		if (radius < 0 || Double.isNaN(radius)) {
			throw new IllegalArgumentException("BadumTss: Bad radius.");
		}
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() {
		super.assertClassInvariants();
		assertIsValidLatitude(this.latitude);
		assertIsValidLongitude(this.longitude);
		assertIsValidRadius(this.radius);
	}

}
