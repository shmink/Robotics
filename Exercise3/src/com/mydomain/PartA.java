package com.mydomain;

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
		Movement move = new Movement();
		while(true)
		{
			move.keepTheDistance(SensorPort.S2, 10);
		}
		
	}
	
	
}
