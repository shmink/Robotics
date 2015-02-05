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
			final Movement move = new Movement();
			move.followPath(SensorPort.S1,SensorPort.S4);
		}
	}
	
}
