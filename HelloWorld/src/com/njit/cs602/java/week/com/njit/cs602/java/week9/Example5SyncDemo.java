package com.njit.cs602.java.week9;

public class Example5SyncDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example5ClassSender snd = new Example5ClassSender();
		Example5ThreadSend s1 = new Example5ThreadSend("Hi", snd);
		Example5ThreadSend s2 = new Example5ThreadSend("Bye", snd);
		
		s1.start();
		s2.start();
		
		//wait for threads to end
		try {
			s1.join();
			s2.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
