package com.mydomain;

import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Class for some of the rotate methods
 *
 */
public class Rotate 
{

	private DifferentialPilot pilot;
	
	
	public Rotate()
	{
		  pilot = new DifferentialPilot(2.6f, 5.2f, Motor.A, Motor.B, false);
	}
	
	/**
	 * Rotate the robot to the left.
	 * @param angle - how much do you want to rotate by?
	 */
	public void rotateLeft(int angle)
	{
		pilot.rotate(-angle);
	}
	
	/**
	 * Rotate the robot to the right.
	 * @param angle - how much do you want to rotate by?
	 */
	public void rotateRight(int angle)
	{
		pilot.rotate(angle);
	}
	
}
