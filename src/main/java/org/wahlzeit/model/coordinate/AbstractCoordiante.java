package org.wahlzeit.model.coordinate;

public abstract class AbstractCoordiante implements Coordinate {

	/**
	 * @methodtype query
	 * @param coordinate
	 * @return distance in kilometer
	 * @throws CoordinateParameterException
	 * @throws CoordinateDistanceException
	 */
	public double getDistance(Coordinate otherCoordinate)
			throws UnknownCoordinateException, CoordinateParameterException, CoordinateDistanceException {

		// check invariants
		assertClassInvariants();

		// precondition
		assertNotNull(otherCoordinate);

		/*
		 * Formula and additional information:
		 * https://en.wikipedia.org/w/index.php?title=Distance&oldid=747860001
		 */

		CartesianCoordinate cartesianCoordinateA = this.asCartesianCoordinate();
		CartesianCoordinate cartesianCoordinateB = otherCoordinate.asCartesianCoordinate();

		double deltaX = Math.pow(cartesianCoordinateA.getX() - cartesianCoordinateB.getX(), 2);
		double deltaY = Math.pow(cartesianCoordinateA.getY() - cartesianCoordinateB.getY(), 2);
		double deltaZ = Math.pow(cartesianCoordinateA.getZ() - cartesianCoordinateB.getZ(), 2);

		double distance = Math.sqrt(deltaX + deltaY + deltaZ);

		// postconditions
		assertIsValidDistance(distance);
		assertClassInvariants();

		return distance;
	}

	public boolean isEqual(Coordinate otherCoordinate) throws UnknownCoordinateException, CoordinateParameterException {

		// check invariants
		assertClassInvariants();

		// precondition
		assertNotNull(otherCoordinate);

		CartesianCoordinate cartesianCoordinateA = this.asCartesianCoordinate();
		CartesianCoordinate cartesianCoordinateB = otherCoordinate.asCartesianCoordinate();

		double xA = cartesianCoordinateA.getX();
		double yA = cartesianCoordinateA.getY();
		double zA = cartesianCoordinateA.getZ();

		double xB = cartesianCoordinateB.getX();
		double yB = cartesianCoordinateB.getY();
		double zB = cartesianCoordinateB.getZ();

		if (xA == xB && yA == yB && zA == zB) {
			// postcondition
			assertClassInvariants();
			return true;
		}

		// postcondition
		assertClassInvariants();

		return false;
	}

	public abstract CartesianCoordinate asCartesianCoordinate() throws CoordinateParameterException;

	/**
	 * @throws UnknownCoordinateException
	 * @methodtype assertion
	 */
	protected void assertNotNull(Coordinate otherCoordinate) throws UnknownCoordinateException {
		if (otherCoordinate == null) {
			throw new UnknownCoordinateException("Coordinate is null!");
		}
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertIsValidDistance(double distance) throws CoordinateDistanceException {
		if (distance < 0) {
			throw new CoordinateDistanceException("Calculated distance is smaller than zero.");
		}
	}

	/**
	 * @throws CoordinateParameterException
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() throws CoordinateParameterException {
		// This method is not required in this abstract class (no state)
	}

}
