package org.wahlzeit.model.coordinate;

public class CoordinateParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CoordinateParameterException() {
		super();
	}

	public CoordinateParameterException(String message) {
		super(message);
	}

	public CoordinateParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoordinateParameterException(Throwable cause) {
		super(cause);
	}
}
