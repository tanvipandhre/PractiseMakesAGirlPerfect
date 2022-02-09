package com.njit.cs602.java;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIOneLabel extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIOneLabel().display();
	}
	private void display() {
		setSize(new Dimension(400,300));
		Container container = getContentPane();
		JLabel label = new JLabel("Hello World");
		container.add(label);
		setVisible(true);
		
	}

}
