package com.mydomain;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;

public class Part1 {

	static int targetDistance;
	
	public static void main (String[] args){
		targetDistance = 150;
		Button.waitForAnyPress();
		run();
	}
	
	static void run(){
		Behavior b1 = new KeepUp(targetDistance);
		Behavior b2 = new TooClose(targetDistance);
		Behavior b3 = new Stay(targetDistance);
		Behavior[] bArray = {b1, b2, b3};
		Arbitrator arby = new Arbitrator(bArray);
		arby.start();
	}
}
