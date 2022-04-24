package com.njit.cs602.java.week3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RedBlueButton extends JFrame implements ActionListener{
	
		JTextField text1, text2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RedBlueButton().display();
	}
	private void display() {
		setSize(new Dimension(400, 300));
		Container container = getContentPane();
		container.setLayout(null);
		
		JButton redButton = new JButton("Red");
		redButton.addActionListener(this);
		redButton.setBounds(44, 40, 70, 30);
		
		JButton blueButton = new JButton("Blue");
		blueButton.addActionListener(this);
		blueButton.setBounds(154, 40, 70, 30);
		
		text1 = new JTextField();
		text1.setBounds(70, 10, 21, 21);
		
		text2 = new JTextField();
		text2.setBounds(178, 10, 21, 21);
		
		container.add(blueButton);
		container.add(redButton);
		container.add(text1);
		container.add(text2);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Red")) {
			text1.setBackground(Color.PINK);
			text2.setBackground(Color.WHITE);
			
		}else if(s.equals("Blue")) {
			text1.setBackground(Color.WHITE);
			text2.setBackground(Color.BLUE);
		}
	}

}
