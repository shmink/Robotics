package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class Part2a
{
	public static void main(String[] args) throws Exception 
	{
		run();
	}
	
	public static void run()
	{
		final Movement move = new Movement();

		System.out.println("Press enter to begin...");
		Button.ENTER.waitForPressAndRelease();
		LCD.clear();
		
		System.out.println("Time to bump and grind");

		while(!Button.ENTER.isDown())
		{
			move.avoidObjects(SensorPort.S2, SensorPort.S3);
		}
	    
	    Button.ESCAPE.waitForPressAndRelease();
	}
}
