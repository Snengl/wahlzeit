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

	public SphericCoordinate(double latitude, double longitude, double radius) throws CoordinateParameterException {

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

	public void setLatitude(double latitude) throws CoordinateParameterException {

		// precondition
		assertIsValidLatitude(latitude);

		this.latitude = latitude;

		// postcondition
		assertClassInvariants();
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) throws CoordinateParameterException {

		// precondition
		assertIsValidLongitude(longitude);

		this.longitude = longitude;

		// postcondition
		assertClassInvariants();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) throws CoordinateParameterException {

		// precondition
		assertIsValidRadius(radius);

		this.radius = radius;

		// postcondition
		assertClassInvariants();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() throws CoordinateParameterException {

		/*
		 * Formula and additional information:
		 * https://en.wikipedia.org/w/index.php?title=
		 * Spherical_coordinate_system&oldid=748510862
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
	 * @throws CoordinateParameterException
	 * @methodtype assertion
	 */
	private void assertIsValidLatitude(double latitude) throws CoordinateParameterException {
		if (latitude < -90 || latitude > 90 || Double.isNaN(latitude)) {
			throw new CoordinateParameterException("BadumTss: Bad latitude.");
		}
	}

	/**
	 * @throws CoordinateParameterException
	 * @methodtype assertion
	 */
	private void assertIsValidLongitude(double longitude) throws CoordinateParameterException {
		if (longitude < -180 || longitude > 180 || Double.isNaN(longitude)) {
			throw new CoordinateParameterException("BadumTss: Bad longitude.");
		}
	}

	/**
	 * @throws CoordinateParameterException
	 * @methodtype assertion
	 */
	private void assertIsValidRadius(double radius) throws CoordinateParameterException {
		if (radius < 0 || Double.isNaN(radius)) {
			throw new CoordinateParameterException("BadumTss: Bad radius.");
		}
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() throws CoordinateParameterException {
		super.assertClassInvariants();

		assertIsValidLatitude(this.latitude);
		assertIsValidLongitude(this.longitude);
		assertIsValidRadius(this.radius);
	}

}
