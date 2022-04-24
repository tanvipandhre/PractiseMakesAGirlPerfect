package com.njit.cs602.java.week3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	
	private int count = 0;
	private JPanel panel;
	private JFrame frame ;
	private JLabel label;
	private JButton button;
	public GUI() {
		frame = new JFrame();
		button = new JButton("Click me!");
		button.addActionListener(this);
		panel = new JPanel();
		label = new JLabel("Number of clicks 0");
		panel.add(label);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		frame.add(panel, BorderLayout.CENTER);
		//frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		count++;
		label.setText("Number of clicks "+ count);
	}

}
