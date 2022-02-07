package com.njit.cs602.java;

public class Book2 {
protected int pages;
	
	//Constructor
	public Book2(int numPages) {
		pages = numPages;
	}
	//pages mutator
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	//pages accessor
	public int getPages() {
		return pages;
	}
}
