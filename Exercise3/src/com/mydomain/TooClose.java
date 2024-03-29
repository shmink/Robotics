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
		return sensor.getDistance() < targetDistance;
	}

	@Override
	public void action() {
		suppressed = false;
		while(suppressed == false){
			System.out.println("reversing");
			double difference = sensor.getDistance() - targetDistance;
			double newSpeed = 5*difference;
			m.reverseWithSpeed((int) newSpeed);
			if(sensor.getDistance() == 300)
				suppressed = true;
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}