package com.njit.cs602.java.week1.part1;

import java.util.Scanner;

//Write a program that reads two floating point numbers and
//prints their sum, difference and product.
public class FloatCalculations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		double num1= sc.nextDouble();
		double num2= sc.nextDouble();
		System.out.println("Sum "+(num1+num2));
		System.out.println("Diff "+(num1-num2));
		System.out.println("Prod "+(num1*num2));
		
		
	}

}
