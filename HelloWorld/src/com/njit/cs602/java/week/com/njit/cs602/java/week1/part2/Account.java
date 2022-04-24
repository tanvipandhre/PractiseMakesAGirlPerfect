package com.njit.cs602.java.week1.part2;

import java.text.NumberFormat;

public class Account {
	private final double RATE = 0.035;
	private long accountNo ;
	private double balance;
	private String name;
	
	public Account(String owner, long account, double initial) {
		name = owner;
		accountNo = account;
		balance = initial;
	}
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	public double withdraw(double amount,double fee) {
		balance = balance - amount - fee;
		return balance;
	}
	public double addInterest() {
		balance += (balance*RATE);
		return balance;
	}
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return (accountNo + "\t" + name + "\t" + fmt.format(balance));
	}
	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRATE() {
		return RATE;
	}
	
}
