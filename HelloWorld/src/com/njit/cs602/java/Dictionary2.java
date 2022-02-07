package com.njit.cs602.java;

public class Dictionary2 extends Book2{
	private int definations;
	public Dictionary2(int numPages, int numDef) {
		super(numPages);
		// TODO Auto-generated constructor stub
		definations = numDef;
	}
	//mutator -setter
	public void setDefinations(int def) {
		this.definations = def;
	}
	
	//accessor
	public int getDefinations() {
		return definations;
	}
	public double computeRatio() {
		return (double)definations/pages;
	}
}
