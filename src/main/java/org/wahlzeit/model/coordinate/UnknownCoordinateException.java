package org.wahlzeit.model.coordinate;

public class UnknownCoordinateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownCoordinateException() {
		super();
	}

	public UnknownCoordinateException(String message) {
		super(message);
	}

	public UnknownCoordinateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownCoordinateException(Throwable cause) {
		super(cause);
	}
}
