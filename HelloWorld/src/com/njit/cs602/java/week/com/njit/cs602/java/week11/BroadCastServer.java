package com.njit.cs602.java.week11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Date;

public class BroadCastServer {

	public static final int PORT = 1200;
	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		
		MulticastSocket multicastSocket;
		DatagramPacket datagramPacket;
		InetAddress inetAddress;
		String group = "225.4.5.6";
		
		inetAddress = InetAddress.getByName(group);
		multicastSocket = new MulticastSocket();
		multicastSocket.joinGroup(inetAddress);
		
		byte[] data = null;
		for(;;) {
			Thread.sleep(1000);
			System.out.println("Sending");
			Date date = new Date();
			String str = date.toString();
			data = str.getBytes();
			datagramPacket = new DatagramPacket(data, str.length(), inetAddress, PORT);
			multicastSocket.send(datagramPacket);
			multicastSocket.close();
		}
		
				
	}

}
