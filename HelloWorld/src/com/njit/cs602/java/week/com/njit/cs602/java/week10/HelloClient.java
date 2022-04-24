package com.njit.cs602.java.week10;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int port = 16790;
			String host = "localhost";
			String registryURL = "rmi://"+host+":"+port+"/hello";
			HelloInterface hi  = (HelloInterface)Naming.lookup(registryURL);
			System.out.println("lookup completed");
			String message = hi.sayHello("Fun Java");
			System.out.println("HelloClient: "+message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
