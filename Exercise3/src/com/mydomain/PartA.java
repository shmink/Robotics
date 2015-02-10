package com.mydomain;
import lejos.robotics.subsumption.*;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;


public class PartA 
{
	public static void main(String[] args)
	{
		Button.waitForAnyPress();
		run();
	}

	private static void run() 
	{
//		Movement move = new Movement();
//		while(true)
//		{
//			move.keepTheDistance(SensorPort.S2, 20);
//		}
//		
		
		while(true){
	    	Behavior b1 = new DriveForward();
			Behavior b2 = new Junction();
			Behavior[] bArray = {b1,b2};
			Arbitrator arby = new Arbitrator(bArray);
			arby.start();
		}

	
	
//		while(true)
//		{
//			Junction b = new Junction();
//			System.out.println(b.test());
//		}
		
	}
	
	
}
