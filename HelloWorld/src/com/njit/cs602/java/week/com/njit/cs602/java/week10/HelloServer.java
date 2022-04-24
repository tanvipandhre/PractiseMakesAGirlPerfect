package com.njit.cs602.java.week10;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		int port = 16790;
		String host = "localhost";
		HelloImpl expObj = new HelloImpl();
		startRegistry(port);
		String registryURL = "rmi://"+host+":"+port+"/hello";
		LocateRegistry.getRegistry(port);
		try {
			Naming.rebind(registryURL, expObj);
			System.out.println("Server is ready");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void startRegistry(int port) throws RemoteException{
		try {
			
			Registry registry = LocateRegistry.getRegistry();
			registry.list();
		}catch(Exception e) {
			System.out.println("RMI registry cannot be located");
			Registry registry = LocateRegistry.createRegistry(port);
			System.out.println("RMI registry created at port"+port);
			e.printStackTrace();
		}
	}

}
