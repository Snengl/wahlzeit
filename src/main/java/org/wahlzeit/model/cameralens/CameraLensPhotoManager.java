package org.wahlzeit.model.cameralens;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import org.wahlzeit.model.PhotoManager;

public class CameraLensPhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final PhotoManager instance = new CameraLensPhotoManager();

	private static final Logger log = Logger.getLogger(CameraLensPhotoManager.class.getName());

	/**
	 *
	 */
	public Set<CameraLensPhoto> findPhotosByCorporation(CameraLensCorporation corporationName) {
		Set<CameraLensPhoto> result = new HashSet<CameraLensPhoto>();
		readObjects(result, CameraLensPhoto.class, CameraLensPhoto.CORPORATION, corporationName);

		for (Iterator<CameraLensPhoto> i = result.iterator(); i.hasNext();) {
			doAddPhoto(i.next());
		}

		return result;
	}

	/**
	 *
	 */
	public Set<CameraLensPhoto> findPhotosByLensType(CameraLensType lensType) {
		Set<CameraLensPhoto> result = new HashSet<CameraLensPhoto>();
		readObjects(result, CameraLensPhoto.class, CameraLensPhoto.LENSTYPE, lensType);

		for (Iterator<CameraLensPhoto> i = result.iterator(); i.hasNext();) {
			doAddPhoto(i.next());
		}

		return result;
	}

}
