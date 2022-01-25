package com.njit.cs652.ihlp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class EchoClient {
	 public static void main(String[] args) {
		try {
			String hostName = args[0];
			int portNumber = Integer.parseInt(args[1]);
			Socket socket = new Socket(hostName,portNumber);
			
			//Socket socket = new Socket("localhost",56);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter hello in small case");
			String inputString = sc.next();
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println(inputString);
			printWriter.flush();
			
			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String  strFromServerInUpperCase = bufferedReader.readLine();
			System.out.println("strFromServerInUpperCase: "+strFromServerInUpperCase);
			System.out.println("Client ran");
			
			socket.close();
			System.out.println("Client ran");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
	}

}
