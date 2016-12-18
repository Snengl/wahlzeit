package org.wahlzeit.model.coordinate;

import java.util.HashMap;
import java.util.HashSet;

public class CartesianCoordinate extends AbstractCoordiante {

	private static final HashMap<Integer, CartesianCoordinate> coordinate = new HashMap<>();

	private final double x;
	private final double y;
	private final double z;

	private CartesianCoordinate(double x, double y, double z) throws CoordinateParameterException {

		// preconditions
		assertIsValidX(x);
		assertIsValidY(y);
		assertIsValidZ(z);

		this.x = x;
		this.y = y;
		this.z = z;

		// postcondition
		assertClassInvariants();
	}

	public static CartesianCoordinate getInstance(double x, double y, double z) throws CoordinateParameterException {

		CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
		
		synchronized (coordinate) {
			if(!coordinate.containsKey(cartesianCoordinate.hashCode())){
				coordinate.put(cartesianCoordinate.hashCode(), cartesianCoordinate);
				return cartesianCoordinate;
			}
			else{
				return coordinate.get(cartesianCoordinate.hashCode());
			}
		}
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/**
	 * @methodtype assertion
	 */
	private void assertIsValidX(double x) throws CoordinateParameterException {
		if (Double.isNaN(x)) {
			throw new CoordinateParameterException("BadumTss: x is not a number");
		}
	}

	/**
	 * @methodtype assertion
	 */
	private void assertIsValidY(double y) throws CoordinateParameterException {
		if (Double.isNaN(y)) {
			throw new CoordinateParameterException("BadumTss: y is not a number");
		}
	}

	/**
	 * @methodtype assertion
	 */
	private void assertIsValidZ(double z) throws CoordinateParameterException {
		if (Double.isNaN(z)) {
			throw new CoordinateParameterException("BadumTss: z is not a number");
		}
	}

	/**
	 * @throws CoordinateParameterException 
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() throws CoordinateParameterException {
		super.assertClassInvariants();
		assertIsValidX(this.x);
		assertIsValidY(this.y);
		assertIsValidZ(this.z);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
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
		CartesianCoordinate other = (CartesianCoordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

}
