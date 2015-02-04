package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.SensorPort;

public class Part3 
{
	public static void main(String[] args)
	{
		run();
	}
	
	public static void run(){
		final Movement move = new Movement();
		Button.ENTER.addButtonListener(new ButtonListener() 
	    {
	      public void buttonPressed(Button b) 
	      {
	        System.out.println("Let's get outta here!");
	        move.escapeMaze(SensorPort.S1, SensorPort.S2, SensorPort.S3,false);
	      }

	      public void buttonReleased(Button b) 
	      {
	      }
	    });
	    
	    Button.ESCAPE.waitForPressAndRelease();
		
	}
}
