package org.wahlzeit.model.coordinate;

public abstract class AbstractCoordiante implements Coordinate {

	/**
	 * @methodtype query
	 * @param coordinate
	 * @return distance in kilometer
	 */
	public double getDistance(Coordinate otherCoordinate) {

		/*
		 * Formula and additional information:
		 * https://en.wikipedia.org/w/index.php?title=Distance&oldid=747860001
		 */

		// precondition
		assertNotNull(otherCoordinate);

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

	public boolean isEqual(Coordinate otherCoordinate) {

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

	public abstract CartesianCoordinate asCartesianCoordinate();

	/**
	 * @methodtype assertion
	 */
	protected void assertNotNull(Coordinate otherCoordinate) {
		if (otherCoordinate == null) {
			throw new IllegalArgumentException("Other coordinate is null!");
		}
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertIsValidDistance(double distance) {
		if (distance < 0) {
			throw new IllegalArgumentException("Calculated distance is smaller than zero.");
		}
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertClassInvariants() {
		// This method is not required in this abstract class (no state)
	}

}
