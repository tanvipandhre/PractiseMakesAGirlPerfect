package com.njit.cs602.java.week10;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class RMIFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream out = null;
		InputStream in = null;
		try {
			URL url = new URL("http://blah.cis.njit.edu/~rsiddique/a.mp4");
			in = url.openStream();
			out = new FileOutputStream("b.mp4");
			int data = in.read();
			while(data != -1) {
				out.write(data);
				data = in.read();
			}
			out.close();
			in.close();
			
		}catch(Exception e) {
			
		}
		System.out.println("prog got terminated");

	}

}
