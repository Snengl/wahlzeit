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
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

}
