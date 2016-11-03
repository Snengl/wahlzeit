package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for the Coordinate class.
 */
public class CoordinateTest {

	@Test
	public void getDistanceWithCoordinates() {

		Coordinate munich = new Coordinate();
		munich.setLatitude(48.137428);
		munich.setLongitude(11.575490);

		Coordinate nueremberg = new Coordinate(49.450520, 11.080480);

		double distanceMucNue = munich.getDistance(nueremberg);
		double distanceNueMuc = nueremberg.getDistance(munich);

		// Calculated distance between NUE and MUC
		double distance = 158;
		
		Assert.assertEquals(distance, distanceMucNue, 1.0);
		Assert.assertEquals(distance, distanceNueMuc, 1.0);
		Assert.assertEquals(distanceMucNue, distanceNueMuc, 0.0);

	}
}
