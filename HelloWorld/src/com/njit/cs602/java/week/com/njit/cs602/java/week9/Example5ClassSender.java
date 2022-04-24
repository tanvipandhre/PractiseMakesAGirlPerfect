package com.njit.cs602.java.week9;

public class Example5ClassSender {
	public void send(String msg) {
		System.out.println("Sending\t"+msg);
		try {
			
			Thread.sleep(1000);
		}catch(Exception e) {
			System.out.println("Thread interrupted");
		}
		System.out.println("\n"+msg+"Sent");
	}
	
	
}
