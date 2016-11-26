package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractCoordinateTest {

	CartesianCoordinate cartesianCoordinate;
	SphericCoordinate sphericCoordinate;

	@Before
	public void setUp() {
		cartesianCoordinate = new CartesianCoordinate(1, 1, 1);
		sphericCoordinate = new SphericCoordinate(0, 0, 0);
	}

	@Test
	public void distanceTest() {
		Assert.assertEquals(1.73, cartesianCoordinate.getDistance(sphericCoordinate), 0.01);
	}

	@Test
	public void distanceSphericCartesianTest() {
		Assert.assertEquals(1.73, sphericCoordinate.getDistance(cartesianCoordinate), 0.01);
	}

	@Test
	public void distanceSphericTest() {
		Assert.assertEquals(0, sphericCoordinate.getDistance(sphericCoordinate), 0.0);
	}

	@Test
	public void distanceCartesianTest() {
		Assert.assertEquals(0, cartesianCoordinate.getDistance(cartesianCoordinate), 0.0);
	}

	@Test
	public void isNotEqual() {
		Assert.assertFalse(cartesianCoordinate.isEqual(sphericCoordinate));
	}

	@Test
	public void isEqualCartesian() {
		Assert.assertTrue(cartesianCoordinate.isEqual(cartesianCoordinate));
	}

	@Test
	public void isEqualSpheric() {
		Assert.assertTrue(sphericCoordinate.isEqual(sphericCoordinate));
	}
}
