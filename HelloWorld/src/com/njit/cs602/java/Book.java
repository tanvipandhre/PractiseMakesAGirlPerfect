package com.njit.cs602.java;

public class Book {
	protected int pages = 1500;
	
	//pages mutator
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	//pages accessor
	public int getPages() {
		return pages;
	}
}
