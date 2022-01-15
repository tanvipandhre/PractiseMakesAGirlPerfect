package com.leetcode.strings;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "fly to the moon    ";
		s = s.trim();
		int len = 0;
		String[] arr = s.split(" ");
		String lastword = arr[arr.length-1];
		System.out.println(lastword);
		System.out.println(lastword.length());
	}

}
