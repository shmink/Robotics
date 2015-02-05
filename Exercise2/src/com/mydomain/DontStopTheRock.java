package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.Sound;
import lejos.util.Delay;

public class DontStopTheRock 
{
	static int A = 440;
	static int Ab = 415;
	static int B = 494;
	static int C = 261;
	static int G = 392;
	static int E = 329;
	static int F = 349;
	static int wait = 500;

	public static void main(String[] args) 
	{
		Button.waitForAnyPress();
		song();
	}

	public static void song()
	{		
		Delay.msDelay(wait);
		Sound.playTone(F, 200);
		Delay.msDelay(wait);
		Sound.playTone(F, 200);
		Delay.msDelay(300);
		Sound.playTone(F, 200);
		Delay.msDelay(300);
		Sound.playTone(F, 200);
		Delay.msDelay(300);
		Sound.playTone(G, 200);
		Delay.msDelay(wait);
		Sound.playTone(Ab, 200);
		Delay.msDelay(wait);
	}
}
