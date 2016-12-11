package org.wahlzeit.model.coordinate;

public class CartesianCoordinate extends AbstractCoordiante {
	private double x;
	private double y;
	private double z;

	public CartesianCoordinate() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}

	public CartesianCoordinate(double x, double y, double z) throws CoordinateParameterException {

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

	public double getX() {
		return x;
	}

	public void setX(double x) throws CoordinateParameterException {
		// precondition
		assertIsValidX(x);

		this.x = x;

		// postcondition
		assertClassInvariants();
	}

	public double getY() {
		return y;
	}

	public void setY(double y) throws CoordinateParameterException {
		// precondition
		assertIsValidY(y);

		this.y = y;

		// postcondition
		assertClassInvariants();
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) throws CoordinateParameterException {
		// precondition
		assertIsValidZ(z);

		this.z = z;

		// postcondition
		assertClassInvariants();
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

}
