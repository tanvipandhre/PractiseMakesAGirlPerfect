package com.leetcode.strings;

public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ammaa";
		s= s.toLowerCase();
		boolean isPalindrome = true;
		char[] arr = s.toCharArray();
		int start = 0;
		int end = s.length()-1;
		while(start<end) {
			if(Character.isLetterOrDigit(arr[start]) && Character.isLetterOrDigit(arr[end])) {
				if(arr[start]!=arr[end]) {
					isPalindrome = false;
				}
				start++;
				end--;
			}else if(Character.isLetterOrDigit(arr[start])) {
				end--;
			}else {
				start++;
			}
		}
		System.out.println(isPalindrome);
	}

}
