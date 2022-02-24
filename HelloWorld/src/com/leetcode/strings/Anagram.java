package com.leetcode.strings;

import java.util.Arrays;

/*Given two stringsaandbconsisting of lowercase characters. The task is to check whether two given strings 
are an anagram of each other or not. An anagram of a string is another 
string that contains the same characters, only the order of characters can be different.*/
public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean flag = true;
		//valuOf converts entire array to string
		String str1 = "act";
		String str2 = "tac";
		
		if(str1.length() != str2.length()) {
			flag = false;
		}
		/*else {
			String str3;
			for(int i=0;i<str1.length();i++) {
				int str2Index = str2.indexOf(str1.charAt(i));
				if(str2Index >= 0) {
					char charToBeReplaced = str2.charAt(str2Index);
					str3 = str2.replaceFirst([charToBeReplaced], '*');
					System.out.println(str3);
					str2 = str3;
				}
			}
		}
		
		for(int i =0 ;i<str2.length();i++) {
			if(str2.charAt(i) == '*') {
				flag = true;
				
			}
			else {
				flag = false;
				break;
			}
		}*/
		else {
			char[] c1 = str1.toCharArray();
			char[] c2 = str2.toCharArray();
			
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			for(int i =0;i<c1.length;i++) {
				if(c1[i] != c2[i]) {
					flag = false;
					break;
				}
			}
		}
		System.out.println(flag);
		
	}

}
