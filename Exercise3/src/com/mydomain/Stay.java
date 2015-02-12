package com.mydomain;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;

public class Stay implements Behavior{

	private int targetDistance;
	private boolean suppressed = false;
	Movement m = new Movement(100,400);
	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S2);
	
	public Stay(int tDistance){
		this.targetDistance = tDistance;
	}
	
	@Override
	public boolean takeControl() {
		return sensor.getDistance() <= (targetDistance+(targetDistance/10)) && sensor.getDistance() > targetDistance+3;
	}

	@Override
	public void action() {
		m.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
