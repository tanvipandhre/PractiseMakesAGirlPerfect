package com.njit.cs602.java.week1.part1;

import java.util.Random;

public class Randomnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random randomNo = new Random();
		int num1 = randomNo.nextInt(10);
		System.out.println("From 0 to 9 = "+ num1);
	}

}
