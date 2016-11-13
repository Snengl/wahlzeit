package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalBlobstoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Assert;

public class CameraLensPhotoTest {

	// https://cloud.google.com/appengine/docs/java/tools/localunittesting#Java_Writing_Datastore_and_memcache_tests
	private static final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalBlobstoreServiceTestConfig());

	private CameraLensPhoto photo;

	@Before
	public void setUp() {
		helper.setUp();
		photo = new CameraLensPhoto();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void corporationTest() {
		photo.setCorporation(CameraLensCorporation.NIKON);

		Assert.assertEquals(CameraLensCorporation.NIKON, photo.getCorporation());
	}

	@Test
	public void lensTypeTest() {
		photo.setLensType(CameraLensType.ZOOM);

		Assert.assertEquals(CameraLensType.ZOOM, photo.getLensType());
	}

}
