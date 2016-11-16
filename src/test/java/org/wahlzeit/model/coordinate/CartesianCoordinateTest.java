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
		a = new CartesianCoordinate(0.0, 0.0, 0.0);
		b = new CartesianCoordinate(1.0, 1.0, 1.0);
		munich = new SphericCoordinate(48.137428, 11.575490, 6731.0);
		nuremberg = new SphericCoordinate(49.450520, 11.080480, 6731.0);
		distance = 1.0;
	}

	@Test
	public void getDistanceTest() {

		double distanceAtoB = a.getDistance(b);
		double distanceBtoA = b.getDistance(a);

		Assert.assertEquals(distance, distanceAtoB, 0.0);
		Assert.assertEquals(distance, distanceBtoA, 0.0);
		Assert.assertEquals(distanceAtoB, distanceBtoA, 0.0);
	}

	@Test
	public void getDistanceWitCartesianCoordinateTest() {
		CartesianCoordinate cartesianNurembreg = new CartesianCoordinate();
		cartesianNurembreg.convertSphericToCartesian(nuremberg);

		CartesianCoordinate cartesianMunich = new CartesianCoordinate();
		cartesianMunich.convertSphericToCartesian(munich);

		Assert.assertEquals(158.0, munich.getDistance(nuremberg), 1.0);
	}

	@Test
	public void calculateDistanceTest() {
		Assert.assertEquals(distance, a.calculateDistance(b), 1.0);
		Assert.assertEquals(distance, b.calculateDistance(a), 1.0);
	}

}
