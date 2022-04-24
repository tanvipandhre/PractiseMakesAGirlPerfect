package com.njit.cs602.java.week3;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleFrame frame = new SimpleFrame();
		frame.display();
	}
	
	private void display() {
		setSize(400, 300);
		setVisible(true);
	}

}
