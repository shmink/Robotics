package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Part2 
{
	static int LIGHTVAL = 45;
	
	public static void main(String[] args)
	{
		LightSensor lsLeft = new LightSensor(SensorPort.S4);
		LightSensor lsRight = new LightSensor(SensorPort.S1);		
		System.out.println(lsLeft.getLightValue()); System.out.println(lsRight.getLightValue());
		Button.waitForAnyPress();
			grid();
	}
	
	private static void grid()
	{
	    Behavior grid = new GridPath(0,0,3,4);
		Behavior[] b = {grid};
		Arbitrator arby = new Arbitrator(b);
		arby.start();
	}

}
