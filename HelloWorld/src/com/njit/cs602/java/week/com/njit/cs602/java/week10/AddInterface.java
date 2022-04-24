package com.njit.cs602.java.week10;

import java.rmi.Remote;

public interface AddInterface extends Remote{
	
	public int add(int x, int y) throws Exception;
}
