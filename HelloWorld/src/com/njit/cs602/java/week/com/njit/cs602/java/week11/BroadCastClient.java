package com.njit.cs602.java.week11;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class BroadCastClient {
	public static final int PORT = 1200;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MulticastSocket multicastSocket;
		DatagramPacket datagramPacket;
		InetAddress inetAddress;
		String group = "225.4.5.6";
		
		inetAddress = InetAddress.getByName(group);
		multicastSocket = new MulticastSocket(BroadCastServer.PORT);
		multicastSocket.joinGroup(inetAddress);
		
		byte[] data = null;
		datagramPacket = new DatagramPacket(data, data.length);
		for(;;) {
			multicastSocket.receive(datagramPacket);
			String str = new String(datagramPacket.getData());
			System.out.println("Time signal received from "+datagramPacket.getAddress()+" Time is: "+str);
			
			
			
		}
	}

}
