package com.njit.cs602.java.week10;

import java.rmi.Naming;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AddImp obj = new AddImp();
		Naming.rebind("ADD", obj);
		System.out.println("server started");
		
	}

}
