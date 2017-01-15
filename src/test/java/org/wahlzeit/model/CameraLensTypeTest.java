package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.model.cameralens.CameraLens;
import org.wahlzeit.model.cameralens.CameraLensType;
import org.wahlzeit.model.cameralens.CameraLensType.LensType;
import org.wahlzeit.model.cameralens.CameraLensTypeException;

public class CameraLensTypeTest {

	@Test
	public void typeTest() {
		CameraLensType cameraLensType = new CameraLensType(LensType.ZOOM);
		Assert.assertEquals(LensType.ZOOM, cameraLensType.getType());
	}

	@Test
	public void subTypeTest() throws CameraLensTypeException {
		CameraLensType zoom = new CameraLensType(LensType.ZOOM);
		CameraLensType mega = new CameraLensType(LensType.MEGAZOOM);
		CameraLensType manual = new CameraLensType(LensType.MANUAL_FOCUS);
		
		zoom.addSubType(mega);
		mega.addSubType(manual);
		
		Assert.assertTrue(zoom.isSubtype(mega));
		Assert.assertTrue(zoom.isSubtype(manual));
		Assert.assertTrue(mega.isSubtype(manual));
	}
	
}
