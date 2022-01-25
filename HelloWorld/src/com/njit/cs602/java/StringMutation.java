package com.njit.cs602.java;

public class StringMutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phrase ="Change is inevitable";
		String mutation1, mutation2, mutation3, mutation4;
		
		System.out.println("Originala String: "+phrase);
		System.out.println("length of string: "+phrase.length());
		mutation1 = phrase.concat(", except for vending machine");
		System.out.println("mutation1"+mutation1);
		mutation2 = mutation1.toUpperCase();
		System.out.println("mutation2"+mutation2);
		mutation3 = mutation2.replace('E', 'X');
		System.out.println("mutation3"+mutation3);
		mutation4 = mutation3.substring(3, 5);
		System.out.println("mutation4"+mutation4);
		
		String test = "hello";
		String mutation = test.substring(2);
		System.out.println(test);
		System.out.println(test.length());
		System.out.println(mutation);
		System.out.println(mutation.length());
		
		
		
		
	}

}
