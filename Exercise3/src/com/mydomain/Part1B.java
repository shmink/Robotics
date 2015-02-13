package com.mydomain;
import lejos.robotics.subsumption.*;
import lejos.nxt.Button;

public class Part1B {

	public static void main (String[] args){
		Button.waitForAnyPress();
		run();		
	}

	static void run(){
		Behavior b1 = new DriveForward();
		Behavior b2 = new keepOnPath();
		Behavior[] bArray = {b1,b2};
		Arbitrator arby = new Arbitrator(bArray);
		arby.start();
	}

}