package org.wahlzeit.model.cameralens;

import java.util.logging.Logger;

import org.wahlzeit.model.PhotoManager;

public class CameraLensPhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final PhotoManager instance = new CameraLensPhotoManager();

	private static final Logger log = Logger.getLogger(CameraLensPhotoManager.class.getName());

}
