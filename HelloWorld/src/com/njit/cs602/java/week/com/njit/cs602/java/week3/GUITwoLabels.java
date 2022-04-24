package com.njit.cs602.java.week3;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUITwoLabels extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUITwoLabels().display();

	}
	private void display() {
		setSize(new Dimension(400,300));
		Container container = getContentPane();
		container.setLayout(null);
		JLabel label1 = new JLabel("Hello");
		label1.setBounds(16, 18, 50, 50);
		JLabel label2 = new JLabel("out there");
		label2.setBounds(16, 33, 50, 50);
		
		container.add(label1);
		container.add(label2);
		setVisible(true);
	}

}
