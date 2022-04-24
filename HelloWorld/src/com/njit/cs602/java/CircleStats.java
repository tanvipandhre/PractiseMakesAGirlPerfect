package com.njit.cs602.java;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CircleStats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int radius;
		double circum , area;
		System.out.println("enter radius = ");
		Scanner sc = new Scanner(System.in);
		radius = sc.nextInt();
		area = Math.PI * Math.pow(radius, 2);
		circum = 2 * Math.PI * radius;
		
		DecimalFormat fmt = new DecimalFormat("0.###");
		String area1 = fmt.format(area);
		System.out.println("Area = "+area1);
		System.out.println("Circumference= "+fmt.format(circum));
		

	}

}
