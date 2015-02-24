package com.mydomain;

import lejos.nxt.SensorPort;
import lejos.nxt.addon.NXTCam;
import lejos.util.Delay;

public class Part3
{
	public static void main(String [] args){
		trackBlueBall();
	}
	
	public static void trackBlueBall()
	{
		NXTCam cam = new NXTCam(SensorPort.S3);
		cam.enableTracking(true);
		cam.setTrackingMode(NXTCam.COLOR);
		cam.sortBy(NXTCam.SIZE);

		while(true)
		{
			int numberOfObjects = cam.getNumberOfObjects();
			System.out.println(cam.getObjectColor(1));
			System.out.println(numberOfObjects);
			Delay.msDelay(200);
			for(int i = 0; i < numberOfObjects; i++)
			{
				cam.getRectangle(i);
			}
		}
	}
}




