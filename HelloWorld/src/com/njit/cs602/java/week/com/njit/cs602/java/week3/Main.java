package com.njit.cs602.java.week3;


/**
 * @author Tanvi Pandhre
 * UCID - tp356
 *
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{
	JTextField text1,text2, text3;
	JRadioButton addButton, subButton, mulButton, divButton;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().display();
	}
	private void display() {
		setSize(new Dimension(700, 500));
		Container container = getContentPane();
		container.setLayout(null);
		container.setBackground(Color.PINK);
		
		text1 = new JTextField();
		text1.setBounds(70, 10, 70, 50);
		
		addButton = new JRadioButton("+");
		addButton.setBounds(200, 10, 50, 30 );
		addButton.addActionListener(this);
		
		subButton = new JRadioButton("-");
		subButton.setBounds(200, 60, 50, 30 );
		subButton.addActionListener(this);
		
		mulButton = new JRadioButton("*");
		mulButton.setBounds(200, 110, 50, 30 );
		mulButton.addActionListener(this);
		
		divButton = new JRadioButton("/");
		divButton.setBounds(200, 160, 50, 30 );
		divButton.addActionListener(this);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(addButton);
		buttonGroup.add(subButton);
		buttonGroup.add(mulButton);
		buttonGroup.add(divButton);
		
		text2 = new JTextField();
		text2.setBounds(300, 10, 70, 50);
		
		JLabel equalLabel = new JLabel("=");
		equalLabel.setBounds(430, 10, 100, 70);
		
		text3 = new JTextField();
		text3.setBounds(500, 10, 70, 50);
		
		container.add(text1);
		container.add(text2);
		container.add(text3);
		container.add(addButton);
		container.add(subButton);
		container.add(mulButton);
		container.add(divButton);
		container.add(equalLabel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String input1 = text1.getText();
		
		
		String input2 = text2.getText();
		int num1=0, num2=0;
		
		try {
			
			
				num1 = Integer.parseInt(input1);
				num2 = Integer.parseInt(input2);
				if(addButton.isSelected()) {
					int sum = num1+num2;
					
					text3.setText(Double.toString(sum));
				}else if(subButton.isSelected()) {
					int diff = num1-num2;
					
					text3.setText(Double.toString(diff));
				}else if(mulButton.isSelected()) {
					int mul = num1*num2;
					
					text3.setText(Double.toString(mul));
				}else if(divButton.isSelected()) {
						double div=0.0;
						if(num2 != 0 ) {
							div =(double) num1/num2;
							text3.setText(Double.toString(div));
						}else {
							div = num1/num2;
							text3.setText("");
						}
						
				}
			
			
			
		}catch(NumberFormatException n) {
			
			  JDialog inputEmptyDialog; 
			   
				  JFrame inputEmptyFrame =new JFrame();
				  inputEmptyDialog = new JDialog(inputEmptyFrame,"Input Empty Frame",true);
				  inputEmptyDialog.setLayout(new FlowLayout()); 
				  if(input1.isEmpty() || input2.isEmpty()) {
					  inputEmptyDialog.add(new JLabel("Input can't be empty.")); 
				  }else {
					  inputEmptyDialog.add(new JLabel("Input is not an int value."));
				  }
				   
				  inputEmptyDialog.setSize(200, 100);
				  inputEmptyDialog.setVisible(true);
			  
			 
			 
				//System.out.println("oops no input");
				//e.printStackTrace();	
			}catch(ArithmeticException a) {
				JDialog input2Zero; 
				   
					  JFrame inputZeroFrame =new JFrame();
					  input2Zero = new JDialog(inputZeroFrame,"Input Empty Frame",true);
					  input2Zero.setLayout(new FlowLayout()); 
					  input2Zero.add(new JLabel("Division by Zero is not possible.")); 
					  input2Zero.setSize(200, 100);
					  input2Zero.setVisible(true);
				  
				
			}
	}

}
