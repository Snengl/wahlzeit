package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class CameraLensPhoto extends Photo {

	private static final long serialVersionUID = 2433819754308655968L;

	public static final String CORPORATION = "corporation";
	public static final String LENSTYPE = "lenstype";

	private CameraLensCorporation corporation;
	private CameraLensType lensType;
	private String aperture;
	private String focalLength;

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
	 * @methodtype constructor
	 */
	public CameraLensPhoto(PhotoId id, CameraLensCorporation corporation, CameraLensType lensType) {
		super(id);
		this.corporation = corporation;
		this.lensType = lensType;
	}

	/**
	 * @methodtype get
	 */
	public CameraLensCorporation getCorporation() {
		return corporation;
	}

	/**
	 * @methodtype set
	 */
	public void setCorporation(CameraLensCorporation corporation) {
		this.corporation = corporation;
	}

	/**
	 * @methodtype get
	 */
	public CameraLensType getLensType() {
		return lensType;
	}

	/**
	 * @methodtype set
	 */
	public void setLensType(CameraLensType lensType) {
		this.lensType = lensType;
	}

	/**
	 * @methodtype get
	 */
	public String getAperture() {
		return aperture;
	}

	/**
	 * @methodtype set
	 */
	public void setAperture(String aperture) {
		this.aperture = aperture;
	}

	/**
	 * @methodtype get
	 */
	public String getFocalLength() {
		return focalLength;
	}

	/**
	 * @methodtype set
	 */
	public void setFocalLength(String focalLength) {
		this.focalLength = focalLength;
	}

}
