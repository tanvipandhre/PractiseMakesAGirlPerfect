package com.njit.cs602.java.week2;

/**
 * @author Tanvi Pandhre
 * UCID - tp356
 *
 */
public class ComputerScienceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComputerScience course1 = new ComputerScience("cs100", 3, "Java Programming", 1);
		ComputerScience course2 = new ComputerScience("cs101", 3, "IHLP", 1);
		ComputerScience course3 = new ComputerScience("cs102", 3, "Database", 1);
		
		//use of setter
		course3.setCourseName("Data Structures");
		//use of getter
		System.out.println(course3.getCourseName());
		//print all courses
		System.out.println(course1);
		System.out.println(course2);
		System.out.println(course3);
		
		
		
	}

}
