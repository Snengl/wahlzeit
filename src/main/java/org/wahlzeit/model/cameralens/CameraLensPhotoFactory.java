package org.wahlzeit.model.cameralens;

import java.util.logging.Logger;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

public class CameraLensPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(CameraLensPhotoFactory.class.getName());

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static PhotoFactory instance = null;

	/**
	 * @methodtype constructor
	 */
	public CameraLensPhotoFactory() {
	}

	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting CameraLensPhotoFactory").toString());
			setInstance(new CameraLensPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(PhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}

	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto() {
		return new CameraLensPhoto();
	}

	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto(PhotoId id) {
		return new CameraLensPhoto(id);
	}

	public Photo createPhoto(PhotoId id, CameraLensCorporation corporation, CameraLensType lensType) {
		return new CameraLensPhoto(id, corporation, lensType);
	}

}
