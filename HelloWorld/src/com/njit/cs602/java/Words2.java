package com.njit.cs602.java;

public class Words2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary2 dictionary2 = new Dictionary2(1500, 52500);
		System.out.println("No of pages = "+dictionary2.getPages());
		System.out.println("No of definations = "+dictionary2.getDefinations());
		System.out.println("Definations per page = "+dictionary2.computeRatio());

	}

}
