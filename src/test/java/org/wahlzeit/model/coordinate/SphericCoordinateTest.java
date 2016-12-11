package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {

	private AbstractCoordiante munich;
	private AbstractCoordiante nuremberg;

	private double distance;
	double distanceMucNue = 0;
	double distanceNueMuc = 0;

	@Before
	public void setUp() {
		try {
			munich = new SphericCoordinate(48.137428, 11.575490, 6731.0);
			nuremberg = new SphericCoordinate(49.450520, 11.080480, 6731.0);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}

		distance = 65.0;
	}

	@Test
	public void getDistanceTest() {

		try {
			distanceMucNue = munich.getDistance(nuremberg);
			distanceNueMuc = nuremberg.getDistance(munich);
		} catch (UnknownCoordinateException | CoordinateParameterException | CoordinateDistanceException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(distance, distanceMucNue, 1.0);
		Assert.assertEquals(distance, distanceNueMuc, 1.0);
		Assert.assertEquals(distanceMucNue, distanceNueMuc, 0.0);
	}

	@Test
	public void asCartesianCoordinateTest() {
		try {
			Assert.assertEquals(901, munich.asCartesianCoordinate().getX(), 1);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals(1005, munich.asCartesianCoordinate().getY(), 1);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals(6594, munich.asCartesianCoordinate().getZ(), 1);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = CoordinateParameterException.class)
	public void LatiduteValueTest1() throws CoordinateParameterException {
		SphericCoordinate coordinate = new SphericCoordinate();
		coordinate.setLatitude(195);
	}

	@Test(expected = CoordinateParameterException.class)
	public void LatiduteValueTest2() throws CoordinateParameterException {
		SphericCoordinate coordinate = new SphericCoordinate();
		coordinate.setLatitude(-90.0000009);
	}

	@Test(expected = CoordinateParameterException.class)
	public void LongitudeValueTest1() throws CoordinateParameterException {
		SphericCoordinate coordinate = new SphericCoordinate();
		coordinate.setLongitude(195);
	}

	@Test(expected = CoordinateParameterException.class)
	public void LongitudeValueTest2() throws CoordinateParameterException {
		SphericCoordinate coordinate = new SphericCoordinate();
		coordinate.setLongitude(-180.0000009);
	}

	@Test(expected = CoordinateParameterException.class)
	public void radiusValueTest() throws CoordinateParameterException {
		SphericCoordinate coordinate = new SphericCoordinate();
		coordinate.setRadius(-1);
	}

	@Test(expected = CoordinateParameterException.class)
	public void constructorTest() throws CoordinateParameterException {
		SphericCoordinate coordinate = new SphericCoordinate(-95.25, 159.03, 0.0);
	}

}
