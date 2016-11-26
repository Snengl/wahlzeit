package org.wahlzeit.model.coordinate;

public abstract class AbstractCoordiante implements Coordinate {

	public double getDistance(Coordinate otherCoordinate) {

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

		return distance;
	}

	public boolean isEqual(Coordinate otherCoordinate) {

		CartesianCoordinate cartesianCoordinateA = this.asCartesianCoordinate();
		CartesianCoordinate cartesianCoordinateB = otherCoordinate.asCartesianCoordinate();

		double xA = cartesianCoordinateA.getX();
		double yA = cartesianCoordinateA.getY();
		double zA = cartesianCoordinateA.getZ();

		double xB = cartesianCoordinateB.getX();
		double yB = cartesianCoordinateB.getY();
		double zB = cartesianCoordinateB.getZ();

		if (xA == xB && yA == yB && zA == zB) {
			return true;
		}
		return false;
	}

	public abstract CartesianCoordinate asCartesianCoordinate();

}
