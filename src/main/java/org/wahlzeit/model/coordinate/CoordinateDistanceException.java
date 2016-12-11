package org.wahlzeit.model.coordinate;

public class CoordinateDistanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CoordinateDistanceException() {
		super();
	}

	public CoordinateDistanceException(String message) {
		super(message);
	}

	public CoordinateDistanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoordinateDistanceException(Throwable cause) {
		super(cause);
	}
}
