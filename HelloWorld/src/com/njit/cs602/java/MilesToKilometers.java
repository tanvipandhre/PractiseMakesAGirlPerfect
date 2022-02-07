//*************************************************************
// Write a program that converts miles to kilometers (1mile = 
// 1.60935 kilometers). Read the miles value from the user as 
// a floating point value.
// **********************************************************
package com.njit.cs602.java;

import java.util.Scanner;

public class MilesToKilometers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double MILES_PER_KILOMETER = 1.60935;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter noOfmile");
		double noOfmile = sc.nextDouble() ;
		double kms = noOfmile * MILES_PER_KILOMETER ;
		System.out.println("Miles in kms"+ kms);
		
	}

}
