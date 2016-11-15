package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.cameralens.CameraLensPhoto;
import org.wahlzeit.model.cameralens.CameraLensPhotoFactory;

import com.google.appengine.tools.development.testing.LocalBlobstoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Assert;

public class CameraLensPhotoFactoryTest {

	// https://cloud.google.com/appengine/docs/java/tools/localunittesting#Java_Writing_Datastore_and_memcache_tests
	private static final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalBlobstoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void createPhotoTest() {
		Assert.assertEquals(CameraLensPhoto.class, CameraLensPhotoFactory.getInstance().createPhoto().getClass());
		Assert.assertEquals(CameraLensPhoto.class,
				CameraLensPhotoFactory.getInstance().createPhoto(new PhotoId(1)).getClass());
	}

	@Test
	public void photoIdTest() {
		Photo photo = CameraLensPhotoFactory.getInstance().createPhoto(new PhotoId(123));
		Assert.assertEquals(123, photo.getId().asInt());
	}

}
