package com.njit.cs602.java;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIButton extends JFrame implements ActionListener{
	JTextField textField;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIButton().display();
	}
	private void display() {
		setSize(new Dimension(400, 300));
		Container container = getContentPane();
		container.setLayout(null);
		
		JButton button = new JButton("Click me");
		button.setBounds(44, 40, 90, 21);
		button.addActionListener(this);
		textField = new JTextField();
		textField.setBounds(149, 40, 200, 21);
		container.add(button);
		container.add(textField);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		textField.setText("you clicked the button");
	}

}
