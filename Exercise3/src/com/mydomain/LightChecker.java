package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class LightChecker {
	
	LightSensor lsLeft;
	LightSensor lsRight;
	
	int high = 0;
	int low = 100;
	
	Rotate r = new Rotate();
	
	public static void main(String[] args)
	{
		Button.waitForAnyPress();
		
		LightChecker l = new LightChecker(SensorPort.S1, SensorPort.S4);
		
		l.checkLightHiLow();
	}
	
	public LightChecker(SensorPort left, SensorPort right)
	{
		this.lsLeft = new LightSensor(left);
		this.lsRight = new LightSensor(right);
		
		lsLeft.getLightValue();  lsRight.getLightValue();

	}
	
	public void checkLightHiLow()
	{
		int count = 0;
		while(count < 8)
		{
			System.out.println(lsLeft.getLightValue());
			if(lsLeft.getLightValue() < low)
			{
				this.low = lsLeft.getLightValue();
			}
			
			if(lsLeft.getLightValue() > high)
			{
				this.high = lsLeft.getLightValue();
			}
			
			Button.waitForAnyPress();
			count++;
		}
		
		System.out.println("Low: " + low);
		System.out.println("High: " + high);

		
		Button.waitForAnyPress();
	}
	
	public int getLow()
	{
		return this.low;
	}
	
	public int getHigh()
	{
		return this.high;
	}

}
