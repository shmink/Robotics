package com.mydomain;


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
			move.followPath();
		}
	}
	
}
