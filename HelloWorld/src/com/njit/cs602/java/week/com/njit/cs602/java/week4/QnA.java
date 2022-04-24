package com.njit.cs602.java.week4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QnA extends JFrame implements ActionListener{
	JLabel q,a;
	JTextArea t;
	JButton b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new QnA().display();
	}
	public void display() {
		JFrame f = new JFrame("Hi");
		JPanel choice = new JPanel();
		choice.setLayout(new BorderLayout());
		choice.setBounds(40, 80, 700, 500);
		/*
		 * q = new JLabel("Question"); q.setBounds(70, 50, 50, 20);
		 * 
		 * t = new JTextArea(); t.setBounds(70, 100, 300, 200);
		 */
		a = new JLabel("Answer"); 
		b= new JButton("Submit");
		 
		 choice.add(b, BorderLayout.WEST);
		 choice.add(a, BorderLayout.CENTER);
		 
		/*
		 * choice.add(q); choice.add(t);
		 */
		 
		 f.add(choice);
		 f.setSize(400, 400);
		 f.setVisible(true);
		 
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
