package com.njit.cs602.java.week1.part1;

public class IceCream {
	enum Flavor{Vanilla, Chocolate, Coffee}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Flavor cone1, cone2, cone3;
		cone1 = Flavor.Vanilla;
		cone2 = Flavor.Coffee;
		System.out.println("cone1 value = "+cone1);
		System.out.println("cone1 ordibal = "+cone1.ordinal());
		System.out.println("cone1 name = "+cone1.name());
		
		System.out.println("cone2 value = "+cone2);
		System.out.println("cone2 ordibal = "+cone2.ordinal());
		System.out.println("cone2 name = "+cone2.name());
		
		cone3 = cone1;
		
		System.out.println("cone3 value = "+cone3);
		System.out.println("cone3 ordibal = "+cone3.ordinal());
		System.out.println("cone3 name = "+cone3.name());

	}

}
