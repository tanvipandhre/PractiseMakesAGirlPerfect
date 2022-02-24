package com.leetcode.strings;

public class NonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs";
		char[] arr = str.toCharArray();
		
		for(int i=0;i<str.length();i++) {
			int flag = 0;
			char c = str.charAt(i);
			for(int j=i+1;j<str.length();j++) {
				if(c == str.charAt(j)) {
					flag = 1;
					break;
				}
				
			}
			if(flag == 0) {
				System.out.println(c);
				break;
			}
		}
		
		
		
	}

}
