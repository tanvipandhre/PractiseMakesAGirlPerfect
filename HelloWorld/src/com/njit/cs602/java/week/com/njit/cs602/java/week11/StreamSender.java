package com.njit.cs602.java.week11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class StreamSender {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("java.net.preferIPv4Stack", true);
		
		try {
			InetAddress group = InetAddress.getByName("225.6.7.8");
			MulticastSocket socket = new MulticastSocket();
			String message = "UDP multicating is lol";
			
			DatagramPacket packet = new DatagramPacket(message.getBytes(),message.length(), group, 1200);
			socket.send(packet);
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
