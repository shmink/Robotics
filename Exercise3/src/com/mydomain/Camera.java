package com.mydomain;

import java.awt.Rectangle;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.NXTCam;


public class Camera {

	final static int INTERVAL = 1000; // milliseconds
	
	public static void main(String [] args) throws Exception 
	{
		NXTCam camera = new NXTCam(SensorPort.S3);
		Movement move = new Movement(100, 200);
		String objects = "Objects: ";
		int numObjects;
		
		camera.sendCommand('B'); // object tracking
		camera.sendCommand('U'); // sort objects by colour
		camera.sendCommand('E'); // start tracking
	
		while(!Button.ESCAPE.isDown()) {
			LCD.clear();
			LCD.drawString(camera.getVendorID(), 0, 0);
			LCD.drawString(camera.getProductID(), 0, 1);
			LCD.drawString(camera.getVersion(), 9, 1);
			LCD.drawString(objects, 0, 2);
			LCD.drawInt(numObjects = camera.getNumberOfObjects(),1,9,2);
			
			if (numObjects >= 1 && numObjects <= 8) {
				for (int i=0;i<numObjects;i++) {
					Rectangle r = camera.getRectangle(i);
					if (r.height > 30 && r.width > 30) {
						LCD.drawInt(camera.getObjectColor(i), 3, 0, 3+i);
						LCD.drawInt(r.width, 3, 4, 3+i);
						LCD.drawInt(r.height, 3, 8, 3+i);
					}
					
				}
			}

			LCD.refresh();
			Thread.sleep(INTERVAL);
		}
		/*System.out.println(""+camera.getObjectColor(0));
		Thread.sleep(INTERVAL);*/
	}
}