package com.njit.cs602.java;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ShowClear extends JFrame implements ActionListener{
	JTextField text;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ShowClear().display();
	}
	private void display() {
		setSize(new Dimension(400,300));
		Container container = getContentPane();
		container.setLayout(null);
		
		JButton showButton = new JButton("Show me");
		showButton.addActionListener(this);
		showButton.setBounds(44, 40, 90, 21);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(44, 61, 90, 21);
		clearButton.addActionListener(this);
		
		text = new JTextField();
		text.setBounds(150, 40, 200, 21);
		
		container.add(showButton);
		container.add(text);
		container.add(clearButton);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Clear")) {
			text.setText("");
		}else if(s.equals("Show me")) {
			text.setText("Have a nice day");
		}
		
	}

}
