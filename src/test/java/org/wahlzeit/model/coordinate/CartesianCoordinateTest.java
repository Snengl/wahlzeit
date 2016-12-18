package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartesianCoordinateTest {

	CartesianCoordinate a;
	CartesianCoordinate b;
	SphericCoordinate munich;
	SphericCoordinate nuremberg;
	double distance;

	@Before
	public void setUp() {
		try {
			a = CartesianCoordinate.getInstance(0.0, 0.0, 0.0);
			b = CartesianCoordinate.getInstance(1.0, 1.0, 1.0);
		} catch (CoordinateParameterException e) {
			/*
			 * Wenn der Code nicht mehr so statisch ist: Besseres Error-Handling
			 * anwenden.
			 */
			e.printStackTrace();
		}
		distance = 1.73;
	}

	@Test
	public void getCartesianDistanceTest() {

		double distanceAtoB = 0;
		double distanceBtoA = 0;

		try {
			distanceAtoB = a.getDistance(b);
			distanceBtoA = b.getDistance(a);
		} catch (UnknownCoordinateException | CoordinateParameterException | CoordinateDistanceException e) {
			/*
			 * Wenn der Code nicht mehr so statisch ist: Besseres Error-Handling
			 * anwenden.
			 */
			e.printStackTrace();
		}

		Assert.assertEquals(distance, distanceAtoB, 0.005);
		Assert.assertEquals(distance, distanceBtoA, 0.005);
		Assert.assertEquals(distanceAtoB, distanceBtoA, 0.005);
	}

}
