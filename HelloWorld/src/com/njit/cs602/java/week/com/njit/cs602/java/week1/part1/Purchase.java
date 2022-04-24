package com.njit.cs602.java.week1.part1;

import java.text.NumberFormat;
import java.util.Scanner;

public class Purchase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double tax_rate = 0.06;
		int quantity;
		double subtotal, tax, totalCost, unitPrice;
		Scanner sc = new Scanner(System.in);
		
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		NumberFormat fmt2 = NumberFormat.getPercentInstance();
		
		System.out.println("enter Quantity =");
		quantity = sc.nextInt();
		
		System.out.println("enter unit price");
		unitPrice = sc.nextDouble();
		
		subtotal = quantity * unitPrice;
		tax = subtotal + tax_rate;
		totalCost = subtotal + tax;
		
		System.out.println("subtotal = "+fmt1.format(subtotal));
		System.out.println("tax = "+ fmt1.format(tax)+ " at "+fmt2.format(tax_rate));
		
	}

}
