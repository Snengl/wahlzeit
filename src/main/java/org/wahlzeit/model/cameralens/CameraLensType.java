package org.wahlzeit.model.cameralens;

import java.util.HashSet;
import java.util.Set;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class CameraLensType extends DataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7865899699376457453L;

	public enum LensType {
		ZOOM, SINGLE_FOCAL_LENGHT, SPECIAL_PURPOSE, TELECONVERTER, MANUAL_FOCUS, MEGAZOOM
	}

	protected Set<CameraLensType> subTypes = new HashSet<CameraLensType>();
	protected CameraLensType superType = null;

	private LensType type;

	/**
	 * @methodtype get
	 */
	public Set<CameraLensType> getSubTypes() {
		return subTypes;
	}

	/**
	 * @methodtype set
	 */
	public void setSubTypes(Set<CameraLensType> subTypes) {
		this.subTypes = subTypes;
	}

	/**
	 * @methodtype get
	 */
	public CameraLensType getSuperType() {
		return superType;
	}

	/**
	 * @methodtype set
	 */
	public void setSuperType(CameraLensType superType) {
		this.superType = superType;
	}

	/**
	 * @methodtype get
	 */
	public LensType getType() {
		return type;
	}

	/**
	 * @methodtype set
	 */
	public void setType(LensType type) {
		this.type = type;
	}

	/**
	 * @methodtype constructor
	 */
	public CameraLensType(LensType type) {
		this.type = type;
	}

	/**
	 * @methodtype create
	 */
	public CameraLens createCameraLens(String lensName, CameraLensType cameraLensType) throws CameraLensTypeException {
		return new CameraLens(lensName, cameraLensType);
	}

	/**
	 * 
	 * @param cameraLensType
	 * @throws CameraLensTypeException
	 */
	public void addSubType(CameraLensType cameraLensType) throws CameraLensTypeException {
		assertLensType(cameraLensType);

		this.setSuperType(cameraLensType);
		subTypes.add(cameraLensType);
	}

	/**
	 * 
	 * @param cameraLens
	 * @return boolean
	 * @throws CameraLensException
	 */
	public boolean hasInstance(CameraLens cameraLens) throws CameraLensException {
		assertCameraLens(cameraLens);

		if (cameraLens.getCameraLensType() == this) {
			return true;
		}
		for (CameraLensType type : subTypes) {
			if (type.hasInstance(cameraLens)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param cameraLensType
	 * @return boolean
	 * @throws CameraLensTypeException
	 */
	public boolean isSubtype(CameraLensType cameraLensType) throws CameraLensTypeException {
		assertLensType(cameraLensType);

		while (subTypes.iterator().hasNext()) {
			if (subTypes.iterator().next() == this) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @methodtype assert
	 */
	private void assertLensType(CameraLensType type) throws CameraLensTypeException {
		if (type == null) {
			throw new CameraLensTypeException("Camera lens type is null!");
		}
	}

	/**
	 * @methodtype assert
	 */
	private void assertCameraLens(CameraLens cameraLens) throws CameraLensException {
		if (cameraLens == null) {
			throw new CameraLensException("Camera lens is null!");
		}
	}

}
