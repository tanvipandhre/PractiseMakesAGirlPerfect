package com.njit.cs602.java.week4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionByZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("enter 2 nums");
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(m/n);
		}catch(ArithmeticException e) {
			System.out.println("Division by 0 is not possible");
		}catch(InputMismatchException i) {
			System.out.println("You must enter integers");
			System.exit(1);//break and control goes outside main method
		}
		System.out.println("End of program");
		
	}

}
