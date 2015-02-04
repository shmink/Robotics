package com.mydomain;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

public class Part1
{	
	public static void main(String[] args) throws Exception 
	{
		run();
	}
	
	public static void run()
	{
		final Movement move = new Movement();
	    Button.ENTER.addButtonListener(new ButtonListener() 
	    {
	      public void buttonPressed(Button b) 
	      {
	        System.out.println("Hello, World!");
	      }

	      public void buttonReleased(Button b) {
	      }
	    });
	    
	    Button.LEFT.addButtonListener(new ButtonListener() 
	    {
	        public void buttonPressed(Button b) {
	        	for(int i = 0; i < 3; i++)
	        	{
	        		System.out.println("Zig zag time!");
	        		move.zigzag(20, 10);
	        	}
	        }

	        public void buttonReleased(Button b) {
	        }
	      });
	    
	    //RIGHT BUTTON PRESSED CALLS THE CIRCLE METHOD
	    Button.RIGHT.addButtonListener(new ButtonListener() 
	    {
	        public void buttonPressed(Button b) {
	        	System.out.println("This normally makes me dizzy");
	        	move.circle(15, (int)(15*Math.PI*2));
	        }

	        public void buttonReleased(Button b) {
	        }
	      });
	    Button.ESCAPE.waitForPressAndRelease();
	}

}
