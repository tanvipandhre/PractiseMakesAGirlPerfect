package com.njit.cs602.java.week9;

public class Example5ThreadSend extends Thread{

	private String msg;
	Example5ClassSender sender;
	
	public Example5ThreadSend(String msg, Example5ClassSender sender) {
		//super();
		this.msg = msg;
		this.sender = sender;
	}

	/**
	 *
	 */
	public void run() {
		synchronized(sender) {
			sender.send(msg);
		}
	}

}
