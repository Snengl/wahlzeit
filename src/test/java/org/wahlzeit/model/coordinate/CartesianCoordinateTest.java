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
		distance = 1.0;
	}

	@Test
	public void getCartesianDistanceTest() {

		double distanceAtoB = a.getDistance(b);
		double distanceBtoA = b.getDistance(a);

		Assert.assertEquals(distance, distanceAtoB, 0.0);
		Assert.assertEquals(distance, distanceBtoA, 0.0);
		Assert.assertEquals(distanceAtoB, distanceBtoA, 0.0);
	}


}
