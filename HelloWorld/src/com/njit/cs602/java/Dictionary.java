package com.njit.cs602.java;

public class Dictionary extends Book {
	private int definations= 52500;
	
	//prints a message using both local and inherited values.
	public double computeRatio() {
		return (double)definations/pages;
	}
	
	//mutator -setter
	public void setDefinations(int def) {
		this.definations = def;
	}
	
	//accessor
	public int getDefinations() {
		return definations;
	}
	
}
