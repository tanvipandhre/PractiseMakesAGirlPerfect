package com.njit.cs602.java.week9;

import java.lang.Runnable;
public class Example3 implements Runnable{
	
	protected int count, inc, delay;

	public Example3(int count, int inc, int delay) {
		//super();
		this.count = count;
		this.inc = inc;
		this.delay = delay;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example3 e1 = new Example3(0, 1, 50);
		Thread t1 = new Thread(e1);
		t1.start();
		
		Example3 e2 = new Example3(0, -1, 100);
		Thread t2 = new Thread(e2);
		t2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(;;) {
				System.out.println(count+"");
				count+=inc;
				Thread.sleep(delay);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
