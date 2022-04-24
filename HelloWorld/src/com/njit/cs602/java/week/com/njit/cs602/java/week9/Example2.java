package com.njit.cs602.java.week9;

public class Example2 extends Thread{
	public void run() {
		try {
			System.out.println("Thread "+ Thread.currentThread().getId()+" is running");
			
		}catch(Exception e) {
			System.out.println("Exception is caught");
		}
	}
	

}
