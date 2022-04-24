package com.njit.cs602.java.week1.part2;

public class RollingDice {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Die die1, die2;
		int sum;
		die1 = new Die();
		die2 = new Die();
		
		die1.roll();
		die2.roll();
		System.out.println("Die 1: "+die1+" Die 2: "+die2);
		
		die1.roll();
		die2.setFaceValue(4);
		System.out.println("Die 1: "+die1+" Die 2: "+die2);
		
		sum = die1.getFaceValue()+die2.getFaceValue();
		System.out.println("Die 1: "+die1+" Die 2: "+die2);
		System.out.println("New Sum: "+sum);
		
	}

}
