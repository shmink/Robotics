package com.mydomain;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;


public class Part2 
{
	public static void main(String[] args)
	{
		LightSensor lsLeft = new LightSensor(SensorPort.S4);
		LightSensor lsRight = new LightSensor(SensorPort.S1);		
		lsLeft.getLightValue(); lsLeft.getLightValue();
		Button.waitForAnyPress();
		//run();
		grid();
	}

	/*private static void run() 
	{

		ArrayList<Direction> path = new ArrayList<Direction>();
		path.add(Direction.RIGHT);
		path.add(Direction.LEFT);
		path.add(Direction.RIGHT);
		path.add(Direction.LEFT);
		path.add(Direction.RIGHT);
		path.add(Direction.LEFT);
		path.add(Direction.RIGHT);
		path.add(Direction.LEFT);
		path.add(Direction.RIGHT);
		path.add(Direction.LEFT);
		path.add(Direction.RIGHT);
		path.add(Direction.LEFT);
		path.add(Direction.RIGHT);
		path.add(Direction.LEFT);
		path.add(Direction.RIGHT);
		path.add(Direction.LEFT);
		
		Behavior b1 = new DriveForward();
		Behavior b2 = new Junction(path);
		Behavior[] bArray = {b1,b2};
		Arbitrator arby = new Arbitrator(bArray);
		arby.start();
		
	}*/
	
	private static void grid()
	{
		GridPath grid = new GridPath(0,0,3,4);
		grid.heading();
	}
	
	
	
}
