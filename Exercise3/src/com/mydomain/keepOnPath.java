package com.mydomain;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

public class keepOnPath implements Behavior {

	Movement m = new Movement(100,400);
	Rotate r = new Rotate();
	LightSensor lsLeft = new LightSensor(SensorPort.S4);
	LightSensor lsRight = new LightSensor(SensorPort.S1);
	private boolean  suppressed = false;

	@Override
	public boolean takeControl() {
		return XOR(lsLeft.getLightValue() <= 40, lsRight.getLightValue() <= 40);
	}

	@Override
	public void action() {
		suppressed = false;
		while(XOR(lsLeft.getLightValue() <= 40, lsRight.getLightValue() <= 40)){
			if(lsLeft.getLightValue() <= 40){
				m.moveLeft();
			}
			else if(lsRight.getLightValue() <= 40){
				m.moveRight();
			}
		}	
	}

	@Override
	public void suppress() {
		suppressed=true;
	}
	
	public boolean XOR(boolean x, boolean y){
		return ((x||y) && (!(x&&y)));
	}

}