package org.wahlzeit.model.coordinate;

public class SphericCoordinate extends AbstractCoordiante {
	protected final double latitude;
	protected final double longitude;
	protected final double radius;

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
		return this.latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}
	
	public double getRadius() {
		return this.radius;
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

		double x = radius * Math.sin(Math.toRadians(longitude)) * Math.cos(Math.toRadians(latitude));
		double y = radius * Math.sin(Math.toRadians(longitude)) * Math.sin(Math.toRadians(latitude));
		double z = radius * Math.cos(Math.toRadians(longitude));

		CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
		
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

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SphericCoordinate other = (SphericCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	
	

}
