package org.wahlzeit.model.coordinate;

import org.junit.Assert;
import org.junit.Test;

public class SphericCoordinateTest {

	SphericCoordinate munich = new SphericCoordinate(48.137428, 11.575490, 6731.0);
	SphericCoordinate nuremberg = new SphericCoordinate(49.450520, 11.080480, 6731.0);

	// Calculated distance between NUE and MUC
	double distance = 158.0;
	
	@Test
	public void getDistanceTest() {

		double distanceMucNue = munich.getDistance(nuremberg);
		double distanceNueMuc = nuremberg.getDistance(munich);


		Assert.assertEquals(distance, distanceMucNue, 1.0);
		Assert.assertEquals(distance, distanceNueMuc, 1.0);
		Assert.assertEquals(distanceMucNue, distanceNueMuc, 0.0);
	}

	@Test
	public void getDistanceWithSphericAndCartesianCoordinateTest(){
		CartesianCoordinate cartesianNurembreg = new CartesianCoordinate();
		cartesianNurembreg.convertSphericToCartesian(nuremberg);
		
		Assert.assertEquals(distance, munich.getDistance(nuremberg), 1.0);
	}
	
	@Test
	public void calculateDistanceTest(){
		Assert.assertEquals(distance, munich.calculateDistance(nuremberg),1.0);
		Assert.assertEquals(distance, nuremberg.calculateDistance(munich),1.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void LatiduteValueTest1(){
			SphericCoordinate coordinate = new SphericCoordinate();
			coordinate.setLatitude(195);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void LatiduteValueTest2(){
			SphericCoordinate coordinate = new SphericCoordinate();
			coordinate.setLatitude(-90.0000009);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void LongitudeValueTest1(){
			SphericCoordinate coordinate = new SphericCoordinate();
			coordinate.setLongitude(195);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void LongitudeValueTest2(){
			SphericCoordinate coordinate = new SphericCoordinate();
			coordinate.setLongitude(-180.0000009);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorTest(){
		SphericCoordinate coordinate = new SphericCoordinate(-95.25,159.03,0.0);
	}


}
