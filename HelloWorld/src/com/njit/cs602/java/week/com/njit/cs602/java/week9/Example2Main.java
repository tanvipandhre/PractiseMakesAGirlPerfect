package com.njit.cs602.java.week9;

public class Example2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;//no of threads
		for(int i=0;i<n;i++) {
			Example2 obj = new Example2();
			obj.start();
		}

	}

}
