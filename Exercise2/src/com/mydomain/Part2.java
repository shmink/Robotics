package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.SensorPort;

public class Part2 
{
	
	public static void main(String[] args) throws Exception 
	{
		run();
	}
	
	public static void run(){
		final Movement move = new Movement();
		
	    Button.ENTER.addButtonListener(new ButtonListener() {
	      public void buttonPressed(Button b) {
	    	  move.avoidObjects(SensorPort.S2, SensorPort.S3);
	      }
	
	      public void buttonReleased(Button b) {
	      }
	    });
	    
	    Button.ESCAPE.waitForPressAndRelease();
	}

}

