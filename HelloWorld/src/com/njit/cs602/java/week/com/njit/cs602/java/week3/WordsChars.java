package com.njit.cs602.java.week3;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class WordsChars extends JFrame implements ActionListener{
	JLabel l1, l2;
	JTextArea area;
	JButton b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WordsChars().display();;
		
	}
	public void display() {
		setSize(new Dimension(700, 500));
		Container container = getContentPane();
		container.setLayout(null);
		
		 l1 = new JLabel("Words");
		 l1.setBounds(70, 50, 100, 50);
		 
		 l2 = new JLabel("Characters");
		 l2.setBounds(280, 50, 100, 50);
		 
		 area = new JTextArea();
		 area.setBounds(70,200, 250, 200);
		 
		 b = new JButton("Count");
		 b.setBounds(190,50,80,20);
		b.addActionListener(this);
		
		container.add(l1);
		container.add(l2);
		container.add(b);
		container.add(area);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String areaText = area.getText();
		int length = areaText.length();
		l2.setText(length+"");
		
		String[] arr = areaText.split(" ");
		int arrLen = arr.length;
		l1.setText(arrLen+"");
		
		
		
	}

}
