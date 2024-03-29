package com.mydomain;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.subsumption.Behavior;

public class KeepUp implements Behavior {

	private int targetDistance;
	private boolean suppressed = false;
	Movement m = new Movement(100,400);
	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S2);
	
	public KeepUp(int distance){
		this.targetDistance = distance;
	}
	
	@Override
	public boolean takeControl() {
		return sensor.getDistance() > (targetDistance+(targetDistance/10));
	}

	@Override
	public void action() {
		suppressed = false;
		while(suppressed == false){
			double difference = sensor.getDistance() - targetDistance;
			double newSpeed = 4*difference;
			m.moveForward((int) newSpeed);
		}
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

}