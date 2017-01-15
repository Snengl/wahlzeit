package org.wahlzeit.model.cameralens;

public class CameraLensException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CameraLensException() {
		super();
	}

	public CameraLensException(String message) {
		super(message);
	}

	public CameraLensException(String message, Throwable cause) {
		super(message, cause);
	}

	public CameraLensException(Throwable cause) {
		super(cause);
	}
	
}
