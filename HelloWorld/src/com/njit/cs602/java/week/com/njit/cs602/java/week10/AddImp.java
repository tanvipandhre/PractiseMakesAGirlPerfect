package com.njit.cs602.java.week10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddImp extends UnicastRemoteObject implements AddInterface{

	protected AddImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int add(int x, int y) throws Exception {
		// TODO Auto-generated method stub
		return x+y;
	}

}
