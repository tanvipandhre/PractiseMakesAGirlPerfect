package com.njit.cs602.java.week4;

public class ZeroSum {
	private int balance=0;
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public static void main(String[] args) {
		
		ZeroSum zs = new ZeroSum();
		MyThread1 t1 = new MyThread1(zs);
		MyThread2 t2 = new MyThread2(zs);
		t1.start();
		t2.start();
		System.out.println("Final balance"+zs.balance);
		
	}
	public synchronized void gainCalories() {
 		
 		
 			balance+=100;
 		
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("gain "+balance);
	
	}
	public  synchronized void burnCalories() {
			
				balance-=100;
			
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("loss "+balance);
	
	}
	
	
}

 
 class MyThread1 extends Thread{
	 
	 private ZeroSum zst1 ;
	 MyThread1(ZeroSum zs){
		 this.zst1=zs;
	 }
	 public void run() {
		 for(int i=0;i<3;i++) {
			 zst1.gainCalories(); 
		 }
		 
	 }
 }
 
 class MyThread2 extends Thread{
	 
	 private ZeroSum zst2 ;
	 MyThread2(ZeroSum zs){
		 this.zst2=zs;
	 }
	 public void run() {
		 for(int i=0;i<3;i++) {
			 zst2.burnCalories();
		 }
		 
	 }
 }
