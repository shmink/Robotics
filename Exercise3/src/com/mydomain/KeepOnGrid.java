package com.mydomain;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class KeepOnGrid implements Behavior {

	Movement m = new Movement(50,100);   
	Rotate r = new Rotate();
	LightSensor lsLeft = new LightSensor(SensorPort.S4);
	LightSensor lsRight = new LightSensor(SensorPort.S1);
	private boolean  suppressed = false;
	DifferentialPilot pilot = new DifferentialPilot(2.6f, 12.3f, Motor.A, Motor.B, false);//was 2.6f and 12.3f
	

	@Override
	public boolean takeControl() {
		return XOR(lsLeft.getLightValue() <= Part2.LIGHTVAL, lsRight.getLightValue() <= Part2.LIGHTVAL);
	}
	
	@Override
	public void action() {
		LCD.drawString("control keepOnGrid", 0, 25);

		suppressed = false;
		Rotate rotate = new Rotate();
		if(lsLeft.getLightValue() <= Part2.LIGHTVAL)
		{
			LCD.drawString("should turn left", 0, 0);
			pilot.rotate(-10);
		}
		
		if(lsRight.getLightValue() <= Part2.LIGHTVAL)
		{
			LCD.drawString("should turn right", 0, 0);
			pilot.rotate(10);
		}
	}

	@Override
	public void suppress() {
		this.suppressed=true;
	}
	
	public boolean XOR(boolean x, boolean y){
		return ((x||y) && (!(x&&y)));
	}

}
