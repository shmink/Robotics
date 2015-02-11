package com.mydomain;

import lejos.nxt.SensorPort;


public class PartB 
{
	public static void main(String[] args)
	{
		run();
	}
	
	public static void run(){
		while(true)
		{
			final Movement move = new Movement(100, 800);
			move.followPath(SensorPort.S1,SensorPort.S4);
		}
	}
	
}
