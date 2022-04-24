package com.njit.cs602.java.week10;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		AddInterface obj = (AddInterface) Naming.lookup("ADD");
		int n = obj.add(5, 4);
		System.out.println("addition is :"+n);
	}

}
