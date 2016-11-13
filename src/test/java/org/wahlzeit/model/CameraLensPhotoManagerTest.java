package org.wahlzeit.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalBlobstoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class CameraLensPhotoManagerTest {

	// https://cloud.google.com/appengine/docs/java/tools/localunittesting#Java_Writing_Datastore_and_memcache_tests
	private static final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalBlobstoreServiceTestConfig());

	PhotoManager manager;

	@Before
	public void setUp() {
		helper.setUp();
		manager = new CameraLensPhotoManager();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void initializeTest() {
		Assert.assertNotNull(manager);
	}

	@Test
	public void classTest() {
		Assert.assertEquals(CameraLensPhotoManager.class, manager.getClass());
	}

	@Test
	public void findCorporationTest() {
		// todo
	}

	@Test
	public void findLensTypeTest() {
		// todo
	}
}
