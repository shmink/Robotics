package com.mydomain;

import java.awt.Rectangle;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.NXTCam;
import lejos.util.Delay;

public class Part3
{	
	static Rotate rotate = new Rotate();
	static Movement move = new Movement(100,200);
	
	public static void main(String [] args){
		trackBlueBall();
	}
	
	public static void trackBlueBall()
	{
		NXTCam cam = new NXTCam(SensorPort.S3);
		
		
		cam.setTrackingMode(NXTCam.COLOR);
		cam.sortBy(NXTCam.SIZE);
		cam.enableTracking(true);

		int xVal = 0;
		while(true)
		{
			int numberOfObjects = cam.getNumberOfObjects();
			Delay.msDelay(200);
			for(int i = 0; i < numberOfObjects; i++)
			{				
				
				LCD.drawInt(cam.getRectangle(i).x, 0, 0);

				LCD.drawInt(xVal, 0, 5);
				
				if(cam.getRectangle(i).x < 50)
				{
					rotate.rotateLeft(20);
				}
				if(cam.getRectangle(i).x >= 50)
				{
					rotate.rotateRight(20);
				}
			}
			
		}
		
	}
}




