package com.mydomain;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class GridPath {
	
	boolean pX, nX, pY, nY; //heading
	int cX, cY;             //current position
	int eX, eY;             //end position
	int horizontalDistance = eX - cX;//simply works out how far it needs to go horizontally
	int verticalDistance = eY - cY;  //does the same but vertically
	
	public GridPath(int currentX, int currentY, int endPositionX, int endPositionY)
	{
		this.cX = currentX;
		this.cY = currentY;
		this.eX = endPositionX;
		this.eY = endPositionY;
	}
	
	public void heading()
	{
		Rotate rotate = new Rotate();
		
		//Horizontal movements
		if(horizontalDistance > 0) //decide whether to turn left or right
		{
			rotate.rotateRight(90);
			countTheJunctions(horizontalDistance);
			pX = true; //robot is now facing EAST
		}
		if(horizontalDistance < 0)
		{
			horizontalDistance *= -1;
			rotate.rotateLeft(90);
			countTheJunctions(horizontalDistance);
			nX = true; //robot is now facing WEST
		}
		
		//vertical movements
		if(verticalDistance > 0)
		{
			if(pX) //if the robot is facing EAST
			{
				rotate.rotateLeft(90);
				pX = false;
			}
			if(nX) //if the robot is facing WEST
			{
				rotate.rotateRight(90);
				nX = false;
			}
			countTheJunctions(verticalDistance);
			pY = true; //it's now facing NORTH
		}
		if(verticalDistance < 0) //less than means travel negative Y aka SOUTH
		{
			if(pX) //if the robot is facing EAST
			{
				rotate.rotateRight(90);
				pX = false;
			}
			if(nX) //if the robot is facing WEST
			{
				rotate.rotateLeft(90);
				nX = false;
			}
			countTheJunctions(verticalDistance);
			nY = true; //it's now facing SOUTH
		}
	}
	
	private void countTheJunctions(int junctions)
	{
		LightSensor lsLeft = new LightSensor(SensorPort.S4);
		LightSensor lsRight = new LightSensor(SensorPort.S1);
		Movement move = new Movement(100,200);
		for (int i = 0; i < junctions;) 
		{
			move.moveForward();
			if(lsLeft.getLightValue() <= 40 || lsRight.getLightValue() <= 40) //increments the for loop as it goes over a junction
				i++;
		}
	}

}