package com.njit.cs652.ihlp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	/**
	 * Name - Tanvi Sangram Pandhre
	 * UCID - tp356
	 * Web page URL - https://web.njit.edu/~tp356/
	 */
	public static void main(String[] args) {
		if(args.length!=1) {
			System.err.println("Usage: java EchoServer <port number>");
			System.exit(-1);
		}
		int portNumber = Integer.parseInt(args[0]);
		try {
			
			
			ServerSocket serverSocket = new ServerSocket(portNumber);
			//ServerSocket serverSocket = new ServerSocket(56);
			Socket socket = serverSocket.accept();
			
			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String  strFromClient = bufferedReader.readLine();
			//System.out.println("strFromClient: "+strFromClient);
			
			String strFromServer = strFromClient.toUpperCase();
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println(strFromServer);
			printWriter.flush();
			//System.out.println("server ran");
			
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception caught when trying to listen on port "
	                + portNumber + " or listening for a connection");
	        System.out.println(e.getMessage());

			//e.printStackTrace();
		}
		
	}
}
