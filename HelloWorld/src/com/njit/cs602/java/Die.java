package com.njit.cs602.java;

public class Die {
	private final int MAX = 6;
	private int faceValue;
	//Constructor set the initial face value
	public Die() {
		faceValue=1;
	}
	//Rolls the die and returns the result
	public int roll() {
		faceValue = (int)(Math.random() * MAX) +1;
		return faceValue;
	}
	//Face value mutator
	public void setFaceValue(int value) {
		faceValue = value;
	}
	//face value accessor
	public int getFaceValue() {
		return faceValue;
	}
	//return string representation of this die
	//it states the currect state of the object
	//we activate this by passing object to sysout
	public String toString() {
		String result = Integer.toString(faceValue);
		return result;
	}
}
