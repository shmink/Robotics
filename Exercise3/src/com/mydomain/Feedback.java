package com.mydomain;

import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.util.Delay;
import lejos.robotics.subsumption.*;

public class Feedback {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpticalDistanceSensor distanceSensor = new OpticalDistanceSensor(SensorPort.S2);
		Movement m = new Movement(100,800);
		double setPoint = 20;
		double outputSpeed = 1;
		final double P = 0.1;
	
		while(distanceSensor.getRange()>setPoint){
			m.moveForward();
			double measuredValue = distanceSensor.getRange();
			double error = setPoint - measuredValue;
			outputSpeed += (P*error);
			
			
			if(distanceSensor.getRange() <= setPoint){
				m.stop();
			}
		}
		
	}

}
