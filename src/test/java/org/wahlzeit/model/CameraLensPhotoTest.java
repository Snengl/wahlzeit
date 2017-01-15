package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.cameralens.CameraLens;
import org.wahlzeit.model.cameralens.CameraLensCorporation;
import org.wahlzeit.model.cameralens.CameraLensPhoto;
import org.wahlzeit.model.cameralens.CameraLensType;
import org.wahlzeit.model.cameralens.CameraLensType.LensType;
import org.wahlzeit.model.cameralens.CameraLensTypeException;

import com.google.appengine.tools.development.testing.LocalBlobstoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Assert;

public class CameraLensPhotoTest {

	// https://cloud.google.com/appengine/docs/java/tools/localunittesting#Java_Writing_Datastore_and_memcache_tests
	private static final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalBlobstoreServiceTestConfig());

	private CameraLensPhoto photo;
	private CameraLensType zoom;

	@Before
	public void setUp() {
		helper.setUp();
		photo = new CameraLensPhoto();
		zoom = new CameraLensType(LensType.ZOOM);

	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void cameraLensTypeTest() throws CameraLensTypeException {
		photo.setCameraLens(new CameraLens("Super toll", zoom));
		Assert.assertEquals(LensType.ZOOM, photo.getCameraLens().getCameraLensType().getType());
	}

}
