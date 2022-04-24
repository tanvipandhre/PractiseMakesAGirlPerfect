package com.njit.cs602.java.week9;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tanvi Pandhre
 * UCID - tp356
 *
 */
public class ZeroSum extends Thread{
	int balance = 0;
	final int MAX = 1000;
	static int gain, loss;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ZeroSum zs1 = new ZeroSum();
		GainCalorieHandler gch = new GainCalorieHandler(zs1);
		
		
		
		
		BurnCalorieHandler bch = new BurnCalorieHandler(zs1);
		List<Thread> threadList = new ArrayList<Thread>();
		Thread t1 = new Thread(gch);
		threadList.add(t1);
		Thread t2 = new Thread(bch);
		threadList.add(t2);
			
			t1.start();
			t2.start();
		for(Thread t:threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println(" Final Balance "+zs1.balance);
		
	}
	
	
	public synchronized void gainCalories() {
		
			balance+=100;
			
			System.out.println("gain "+balance);
		
		
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	public synchronized void burnCalories() {
			balance -= 100;
			 System.out.println("loss "+balance);
			 try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	private static class GainCalorieHandler extends Thread{
		private ZeroSum zs1;
		
		public GainCalorieHandler(ZeroSum zs1) {
			this.zs1 = zs1;
		}
		
		public void run() {
			
				for(int i=0;i<10;i++) {
					zs1.gainCalories();
				}
			
			
			
		}
	}
	private static class BurnCalorieHandler extends Thread{
		private ZeroSum zs1;
		
		public BurnCalorieHandler(ZeroSum zs1) {
			this.zs1 = zs1;
		}
		
		public void run() {
			//System.out.println("Thread is running");
				for(int i=0;i<10;i++) {
					zs1.burnCalories();
				}
			
		}
	}
}
