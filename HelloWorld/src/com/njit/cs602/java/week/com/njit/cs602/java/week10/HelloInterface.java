package com.njit.cs602.java.week10;
import java.rmi.Remote;
public interface HelloInterface {
	
		public String sayHello(String name) throws java.rmi.RemoteException;
}
