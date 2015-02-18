package com.mydomain;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

public class GridPath implements Behavior{

	boolean pX, nX, pY, nY; //heading
	int cX, cY;             //current position
	int eX, eY;             //end position
	int horizontalDistance; //simply works out how far it needs to go horizontally
	int verticalDistance;   //does the same but vertically
	boolean suppressed = false;
	LightSensor lsLeft = new LightSensor(SensorPort.S4);
	LightSensor lsRight = new LightSensor(SensorPort.S1);

	public boolean takeControl() {
		return lsRight.getLightValue()>40 && lsLeft.getLightValue()>40;
	}
	
	public GridPath(int currentX, int currentY, int endPositionX, int endPositionY)
	{
		this.cX = currentX;
		this.cY = currentY;
		this.eX = endPositionX;
		this.eY = endPositionY;

		horizontalDistance = eX - cX;//simply works out how far it needs to go horizontally
		verticalDistance = eY - cY;  //does the same but vertically
	}

	public void action() {
		suppressed = false;

		Rotate rotate = new Rotate();

		//Horizontal movements
		if(horizontalDistance > 0) //decide whether to turn left or right
		{
			rotate.rotateRight(90);
			countTheJunctions(horizontalDistance);
			while(Motor.A.isMoving() && Motor.B.isMoving())
				Thread.yield();
			pX = true; //robot is now facing EAST
		}
		if(horizontalDistance < 0)
		{
			horizontalDistance *= -1;
			rotate.rotateLeft(90);
			countTheJunctions(horizontalDistance);
			while(Motor.A.isMoving() && Motor.B.isMoving())
				Thread.yield();
			nX = true; //robot is now facing WEST
		}

		//vertical movements
		if(verticalDistance > 0)
		{
			if(pX) //if the robot is facing EAST
			{
				rotate.rotateLeft(90);
				while(Motor.A.isMoving() && Motor.B.isMoving())
					Thread.yield();
				pX = false;
			}
			if(nX) //if the robot is facing WEST
			{
				rotate.rotateRight(90);
				while(Motor.A.isMoving() && Motor.B.isMoving())
					Thread.yield();
				nX = false;
			}
			countTheJunctions(verticalDistance);
			while(Motor.A.isMoving() && Motor.B.isMoving())
				Thread.yield();
			pY = true; //it's now facing NORTH
		}
		if(verticalDistance < 0) //less than means travel negative Y aka SOUTH
		{
			if(pX) //if the robot is facing EAST
			{
				rotate.rotateRight(90);
				pX = false;
				nY = true;
			}
			if(nX) //if the robot is facing WEST
			{
				rotate.rotateLeft(90);
				nX = false;
				nY = true;
			}
			countTheJunctions(verticalDistance);
			
		}
		while(Motor.A.isMoving() && Motor.B.isMoving())
			Thread.yield();
	}

	private void countTheJunctions(int junctions)
	{
		LightSensor lsLeft = new LightSensor(SensorPort.S4);
		LightSensor lsRight = new LightSensor(SensorPort.S1);
		Movement move = new Movement(100,200);
		for (int i = 0; i < junctions;) 
		{
			move.moveForward();
			System.out.println("count the junctions " + i); 		
			if(lsLeft.getLightValue() <= 40 && lsRight.getLightValue() <= 40){ //increments the for loop as it goes over a junction
				move.travelForward(2);
				i++;
			}
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}
