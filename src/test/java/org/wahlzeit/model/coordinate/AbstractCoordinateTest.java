package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractCoordinateTest {

	CartesianCoordinate cartesianCoordinate;
	SphericCoordinate sphericCoordinate;

	@Before
	public void setUp() {
		try {
			cartesianCoordinate = CartesianCoordinate.getInstance(1, 1, 1);
			sphericCoordinate = SphericCoordinate.getInstance(0, 0, 0);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void distanceTest() {
		try {
			Assert.assertEquals(1.73, cartesianCoordinate.getDistance(sphericCoordinate), 0.01);
		} catch (UnknownCoordinateException | CoordinateParameterException | CoordinateDistanceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void distanceSphericCartesianTest() {
		try {
			Assert.assertEquals(1.73, sphericCoordinate.getDistance(cartesianCoordinate), 0.01);
		} catch (UnknownCoordinateException | CoordinateParameterException | CoordinateDistanceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void distanceSphericTest() {
		try {
			Assert.assertEquals(0, sphericCoordinate.getDistance(sphericCoordinate), 0.0);
		} catch (UnknownCoordinateException | CoordinateParameterException | CoordinateDistanceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void distanceCartesianTest() {
		try {
			Assert.assertEquals(0, cartesianCoordinate.getDistance(cartesianCoordinate), 0.0);
		} catch (UnknownCoordinateException | CoordinateParameterException | CoordinateDistanceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isNotEqual() {
		try {
			Assert.assertFalse(cartesianCoordinate.isEqual(sphericCoordinate));
		} catch (UnknownCoordinateException | CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isEqualCartesian() {
		try {
			Assert.assertTrue(cartesianCoordinate.isEqual(cartesianCoordinate));
		} catch (UnknownCoordinateException | CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isEqualSpheric() {
		try {
			Assert.assertTrue(sphericCoordinate.isEqual(sphericCoordinate));
		} catch (UnknownCoordinateException | CoordinateParameterException e) {
			e.printStackTrace();
		}
	}
}
