package com.njit.cs602.java.week2;

public class Advice extends Thought{
	public void message() {
		System.out.println("Warning: Dtaes in the calendar are closer "+"than they appear");
		System.out.println();
		super.message();//calling parent's message method
	}
	
}
