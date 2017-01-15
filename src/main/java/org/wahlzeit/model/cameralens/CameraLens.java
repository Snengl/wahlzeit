package org.wahlzeit.model.cameralens;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class CameraLens extends DataObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8982483122642623140L;
	
	private CameraLensType cameraLensType;
	private String cameraLensName;
	
	/**
	 * @methodtype constructor
	 */
	public CameraLens(String cameraLensName, CameraLensType cameraLensType) throws CameraLensTypeException {
		assertLensType(cameraLensType);
		this.cameraLensName = cameraLensName;
		this.cameraLensType = cameraLensType;
	}

	/**
	 * @methodtype get
	 */
	public CameraLensType getCameraLensType() {
		return cameraLensType;
	}

	/**
	 * @methodtype set
	 */
	public void setCameraLensType(CameraLensType cameraLensType) {
		this.cameraLensType = cameraLensType;
	}

	/**
	 * @methodtype get
	 */
	public String getCameraLensName() {
		return cameraLensName;
	}

	/**
	 * @methodtype set
	 */
	public void setCameraLensName(String cameraLensName) {
		this.cameraLensName = cameraLensName;
	}

	/**
	 * @methodtype assert
	 */
	private void assertLensType(CameraLensType type) throws CameraLensTypeException {
		if (type == null) {
			throw new CameraLensTypeException("Camera lens type is null!");
		}
	}

	@Override
	public String toString() {
		return "CameraLens [cameraLensType=" + cameraLensType + ", cameraLensName=" + cameraLensName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cameraLensName == null) ? 0 : cameraLensName.hashCode());
		result = prime * result + ((cameraLensType == null) ? 0 : cameraLensType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CameraLens other = (CameraLens) obj;
		if (cameraLensName == null) {
			if (other.cameraLensName != null)
				return false;
		} else if (!cameraLensName.equals(other.cameraLensName))
			return false;
		if (cameraLensType == null) {
			if (other.cameraLensType != null)
				return false;
		} else if (!cameraLensType.equals(other.cameraLensType))
			return false;
		return true;
	}

}
