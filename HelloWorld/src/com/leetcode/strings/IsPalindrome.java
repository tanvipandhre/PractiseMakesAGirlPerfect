package com.leetcode.strings;

public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "mama";
		s= s.toLowerCase();
		boolean isPalindrome = true;
		char[] arr = s.toCharArray();
		int start = 0;
		int end = s.length()-1;
		while(start<end) {
			if(Character.isLetterOrDigit(arr[start]) && Character.isLetterOrDigit(arr[end])) {
				if(arr[start]!=arr[end]) {
					isPalindrome = false;
					break;
				}
				start++;
				end--;
			}
		}
		System.out.println(isPalindrome);
	}

}
