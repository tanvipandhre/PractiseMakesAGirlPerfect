package com.njit.cs602.java;
/**
 * @author Tanvi Pandhre
 * UCID - tp356
 *
 */
public class ComputerScience {
	private String courseID;
	private double credit;
	private String courseName;
	private int semester;
	public ComputerScience(String courseID, double credit, String courseName, int semester) {
		super();
		this.courseID = courseID;
		this.credit = credit;
		this.courseName = courseName;
		this.semester = semester;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	@Override
	public String toString() {
		return "ComputerScience [courseID=" + courseID + ", credit=" + credit + ", courseName=" + courseName
				+ ", semester=" + semester + "]";
	}
	
	
}
