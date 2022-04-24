package com.njit.cs602.java.week9;

public class Example1 extends Thread {

	protected int count, inc, delay;

	public Example1(int count, int inc, int delay) {
		//super();
		this.count = count;
		this.inc = inc;
		this.delay = delay;
	}
	public void run() {
		try {
			
			for(;;) {
				System.out.println(count+"");
				count+=inc;
				sleep(delay);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Example1(0, 1, 50).start();
		new Example1(0, -1, 100).start();
	}
	
}
