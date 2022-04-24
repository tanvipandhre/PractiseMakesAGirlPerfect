package com.njit.cs602.java.week11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Tanvi Pandhre
 * UCID - tp356
 *
 */
public class StreamReceiver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			InetAddress group = InetAddress.getByName("225.6.7.8");
			MulticastSocket socket = new MulticastSocket(1200);
			socket.joinGroup(group);
			
			int i = 0;
			while(i<1) {
				byte[] buffer = new byte[100];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				String receivedString = new String(buffer);
				System.out.println(receivedString);
				
				System.out.println("Received String length"+receivedString.length());
				System.out.println("Group: "+group.toString());
				System.out.println("Port: "+socket.getPort());
				i++;
			}
			
			
			
			socket.close();
			System.out.println("Socket got closed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
