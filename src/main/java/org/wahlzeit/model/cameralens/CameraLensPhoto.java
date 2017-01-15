package org.wahlzeit.model.cameralens;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.coordinate.CoordinateParameterException;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class CameraLensPhoto extends Photo {

	private static final long serialVersionUID = 2433819754308655968L;

	private CameraLens cameraLens;

	/**
	 * @methodtype constructor
	 */
	public CameraLensPhoto() {
		super();
	}

	/**
	 * @methodtype constructor
	 */
	public CameraLensPhoto(PhotoId id) {
		super(id);
	}

	/**
	 * @throws CameraCorporationException
	 * @throws CameraLensTypeException
	 * @methodtype constructor
	 */
	public CameraLensPhoto(PhotoId id, CameraLens cameraLens) throws CameraLensException {
		super(id);

		// preconditions
		assertCameraLens(cameraLens);
		this.cameraLens = cameraLens;
	}

	private void assertCameraLens(CameraLens cameraLens) throws CameraLensException {
		if (cameraLens == null) {
			throw new CameraLensException("Camera lens is null!");
		}
	}

	/**
	 * @methodtype get
	 */
	public CameraLens getCameraLens() {
		return cameraLens;
	}

	/**
	 * @methodtype set
	 */
	public void setCameraLens(CameraLens cameraLens) {
		this.cameraLens = cameraLens;
	}
	
	

}
