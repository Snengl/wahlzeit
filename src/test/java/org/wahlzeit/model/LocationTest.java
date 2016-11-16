package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.model.coordinate.SphericCoordinate;

/**
 * Test for the Location class.
 */
public class LocationTest {

	@Test
	public void coordinateTest() {
		Location l = new Location(new SphericCoordinate(2.54, 100.35,6371.0));

		SphericCoordinate c = new SphericCoordinate();
		c.setLatitude(l.coordinate.getLatitude());
		c.setLongitude(l.coordinate.getLongitude());

		Assert.assertTrue(
				l.coordinate.getLatitude() == c.getLatitude() && l.coordinate.getLongitude() == c.getLongitude());
	}

	@Test
	public void getDistanceWithLocations() {
		Location nuremberg = new Location(49.450520, 11.080480);
		Location munich = new Location(48.137428, 11.575490);

		double distanceMucNue = munich.getDistance(nuremberg);
		double distanceNueMuc = nuremberg.getDistance(munich);

		// Calculated distance between NUE and MUC
		double distance = 150;

		Assert.assertEquals(distance, distanceMucNue, 1.0);
		Assert.assertEquals(distance, distanceNueMuc, 1.0);
		Assert.assertEquals(distanceMucNue, distanceNueMuc, 0.0);
	}

}
