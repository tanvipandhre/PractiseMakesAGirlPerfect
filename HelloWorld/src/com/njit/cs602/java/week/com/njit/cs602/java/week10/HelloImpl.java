package com.njit.cs602.java.week10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface{

	protected HelloImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public String sayHello(String name) throws RemoteException{
		return "Hello World"+name;
	}
	
}
