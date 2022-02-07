package com.njit.cs602.java;

public class Transactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account1 = new Account("Tanvi" , 1000, 38000 );
		Account account2 = new Account("Deepti" , 2000, 50000 );
		Account account3 = new Account("Neha" , 3000, 70000 );
		account1.deposit(45000);
		account3.withdraw(2000, 10);
		account1.addInterest();
		account2.addInterest();
		account3.addInterest();
		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
	}

}
