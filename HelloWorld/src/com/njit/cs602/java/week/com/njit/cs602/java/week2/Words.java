package com.njit.cs602.java.week2;

public class Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary dictionary = new Dictionary();
		System.out.println("No of pages = "+dictionary.getPages());
		System.out.println("No of definations = "+dictionary.getDefinations());
		System.out.println("Definations per page = "+dictionary.computeRatio());
	}

}
