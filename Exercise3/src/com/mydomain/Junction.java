package com.mydomain;
import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class Junction implements Behavior{

	private boolean  suppressed = false;
	Rotate r = new Rotate();
	Movement m = new Movement();
	LightSensor lsLeft = new LightSensor(SensorPort.S4);
	LightSensor lsRight = new LightSensor(SensorPort.S1);
	
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
		r.rotateLeft(90);
		while(Motor.A.isMoving() && Motor.B.isMoving())
			Thread.yield();
		m.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
