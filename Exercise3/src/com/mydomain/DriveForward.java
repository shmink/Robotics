package com.mydomain;
import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class DriveForward implements Behavior {

	Movement m = new Movement(100,400);
	private boolean suppressed = false;

	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		suppressed = false;
		m.moveForward();
//		while(!suppressed)
//			Thread.yield();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
