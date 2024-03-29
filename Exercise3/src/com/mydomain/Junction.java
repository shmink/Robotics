package com.mydomain;
import java.util.ArrayList;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class Junction implements Behavior{

	private boolean  suppressed = false;
	ArrayList<Direction> path;
	Rotate r = new Rotate();
	Movement m = new Movement(60,200);
	LightSensor lsLeft = new LightSensor(SensorPort.S4);
	LightSensor lsRight = new LightSensor(SensorPort.S1);
	
	public Junction(ArrayList<Direction> path){
		this.path = path;
	}
	
	public String test()
	{
			return lsLeft.getLightValue() + " & " + lsRight.getLightValue();
	}
	
	@Override
	/*public boolean takeControl() {
		return lsLeft.getLightValue() <= 20 && lsRight.getLightValue() <= 20;
	}*/
	
	public boolean takeControl() {
		return lsLeft.getLightValue() <= 40 && lsRight.getLightValue() <= 40;
	}

	@Override
	public void action() {
		suppressed = false;
		this.decidePath();
		while(Motor.A.isMoving() && Motor.B.isMoving())
			Thread.yield();
		m.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

	public void decidePath(){
		m.travelForward(3);
		if(path.get(0) == Direction.LEFT){
			r.rotateLeft(90);
			LCD.drawString("left", 0, 0);
		}
		 if (path.get(0) == Direction.RIGHT){
			r.rotateRight(90);
			LCD.drawString("right", 0, 0);
		}
		 if (path.get(0) == Direction.FORWARD){
			m.moveForward(); 
			LCD.drawString("forward", 0, 0);
		}
		 if (path.get(0) == Direction.BACKWARD){
			m.reverseWithSpeed(200);
			LCD.drawString("backward", 0, 0);
		}
		
		if(!path.isEmpty())
			 path.remove(0);
	}

}
