package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.model.coordinate.CoordinateDistanceException;
import org.wahlzeit.model.coordinate.CoordinateParameterException;
import org.wahlzeit.model.coordinate.SphericCoordinate;
import org.wahlzeit.model.coordinate.UnknownCoordinateException;

/**
 * Test for the Location class.
 */
public class LocationTest {

	@Test
	public void coordinateTest() {
		Location l = null;
		try {
			l = new Location(SphericCoordinate.getInstance(2.54, 100.35, 6371.0));
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}

		SphericCoordinate c = null;
		try {
			c = SphericCoordinate.getInstance(l.coordinate.getLatitude(), l.coordinate.getLongitude(), 1);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(
				l.coordinate.getLatitude() == c.getLatitude() && l.coordinate.getLongitude() == c.getLongitude());
	}

	@Test
	public void getDistanceWithLocations() {
		Location nuremberg = null;
		Location munich = null;
		
		try {
			nuremberg = new Location(49.450520, 11.080480);
			munich = new Location(48.137428, 11.575490);
		} catch (CoordinateParameterException e1) {
			e1.printStackTrace();
		}

		double distanceMucNue = 0;
		double distanceNueMuc = 0;
		
		try {
			distanceMucNue = munich.getDistance(nuremberg);
			distanceNueMuc = nuremberg.getDistance(munich);
		} catch (CoordinateParameterException | CoordinateDistanceException | UnknownCoordinateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Calculated cartesian distance between NUE and MUC
		double distance = 62;

		Assert.assertEquals(distance, distanceMucNue, 1.0);
		Assert.assertEquals(distance, distanceNueMuc, 1.0);
		Assert.assertEquals(distanceMucNue, distanceNueMuc, 0.0);
	}

}
