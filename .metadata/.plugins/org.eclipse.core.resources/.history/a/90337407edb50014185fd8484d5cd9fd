package com.mydomain;
import lejos.nxt.*;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.subsumption.Behavior;

public class TooClose implements Behavior {

	private int targetDistance;
	private boolean suppressed = false;
	Movement m = new Movement(100,400);
	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S2);
	
	public TooClose(int tDistance){
		this.targetDistance = tDistance;
	}
	
	@Override
	public boolean takeControl() {
		return sensor.getDistance() < (targetDistance-(targetDistance/10));
	}

	@Override
	public void action() {
		suppressed = false;
		Motor.A.setSpeed(sensor.getDistance());
		Motor.B.setSpeed(sensor.getDistance());
		m.reverse();
		System.out.println("reversing");
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}
