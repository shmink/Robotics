package com.mydomain;
import java.util.ArrayList;

import lejos.robotics.subsumption.*;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;


public class PartA 
{
	public static void main(String[] args)
	{
		LightSensor lsLeft = new LightSensor(SensorPort.S4);
		LightSensor lsRight = new LightSensor(SensorPort.S1);		
		lsLeft.getLightValue(); lsLeft.getLightValue();
		Button.waitForAnyPress();
//		System.out.println(lsLeft.getLightValue()+" & "+lsRight.getLightValue());
		run();
	}

	private static void run() 
	{
		Movement move = new Movement(100,800);

//		ArrayList<Direction> path = new ArrayList<Direction>();
//		path.add(Direction.RIGHT);
//		path.add(Direction.LEFT);
//		path.add(Direction.RIGHT);
//		path.add(Direction.LEFT);
//		path.add(Direction.RIGHT);
//		path.add(Direction.LEFT);
//		path.add(Direction.RIGHT);
//		path.add(Direction.LEFT);
//		
//		Behavior b1 = new DriveForward();
//		//Behavior b2 = new Junction(path);
//		Behavior b3 = new keepOnPath();
//		Behavior[] bArray = {b1,b3};
//		Arbitrator arby = new Arbitrator(bArray);
//		arby.start();

		while(true){
			move.keepTheDistance(SensorPort.S2, 15);
		}
//		while(true)
//		{
//			Junction b = new Junction();
//			System.out.println(b.test());
//		}
		
	}
	
	
}
