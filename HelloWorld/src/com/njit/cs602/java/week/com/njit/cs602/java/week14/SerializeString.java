package com.njit.cs602.java.week14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal lion = new Animal("Lion, The KING");
		try {
			writeToFile(lion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			readFile();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void writeToFile(Animal an) throws FileNotFoundException, IOException {
		@SuppressWarnings("resource")
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Animal.bin"));
		out.writeObject(an);
		
	}
	public static void readFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Animal.bin"));
		Animal animal = (Animal)in.readObject() ;
		System.out.println(animal);
		
	}
	static class Animal implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String name;
		public Animal(String name) {
			this.name = name;
		}
		public String toString() {
			return "The animal is :"+name;
			
		}
	}

}
