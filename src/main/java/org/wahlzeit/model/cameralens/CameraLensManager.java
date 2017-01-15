package org.wahlzeit.model.cameralens;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import org.wahlzeit.model.cameralens.CameraLensType.LensType;
import org.wahlzeit.services.ObjectManager;

public class CameraLensManager extends ObjectManager {

	private static CameraLensManager instance = new CameraLensManager();
	private Map<Integer, CameraLens> cameraLenses = new HashMap<>();

	private CameraLensManager() {
	}

	public static synchronized CameraLensManager getInstance() {
		if (instance == null) {
			instance = new CameraLensManager();
		}
		return instance;
	}

	public CameraLens createCameraLens(@Nonnull String cameraLensName, CameraLensType.LensType cameraLensType)
			throws CameraLensTypeException {
		assertLensType(cameraLensType);

		CameraLensType lensType = new CameraLensType(cameraLensType);
		CameraLens cameraLens = lensType.createCameraLens(cameraLensName, lensType);
		cameraLenses.put(cameraLens.hashCode(), cameraLens);

		return cameraLens;

	}

	/**
	 * @methodtype assert
	 */
	private void assertLensType(LensType cameraLensType) throws CameraLensTypeException {
		if (cameraLensType == null) {
			throw new CameraLensTypeException("Camera lens type is null!");
		}
	}

}
